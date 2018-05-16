import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static final String filePath = "example (1).csv";

	public static void main(String[] args) {

		DataSet dataset = Util.readCSV(filePath);
		// Util.printDataSet(dataset);

		// System.out.println(dataset.majorityClass);

		List<Integer> attrList = new ArrayList();
		for (int i = 0; i < dataset.data.get(0).length -1; i++) {
			attrList.add(i);
		}
		Node root = buildTree(dataset, attrList);

		Util.printTree(root);

		/*List<String[]> validationData = new ArrayList();
		for (String[] strings : validationData) {
			String result = predict(root, strings);
			if(result.equalsIgnoreCase(strings[strings.length-1])) {
				System.out.println("true");
			}
		}*/
		//String[] inpRec = {"youth","high","no","fair", "no;"};
		//System.out.println(predict(root, inpRec));
		
	}
	
	public static String predict(Node root, String[] inpRecord) {
		if(root.attr == -1) {
			return root.label;
		}
		for (BranchDecision branch : root.branches) {
			if(branch.equalTo.equals(inpRecord[root.attr])) {
				return predict(branch.resultant, inpRecord);
			}
		}
		return null;
	}

	public static Node buildTree(DataSet dataset, List<Integer> attrList) {
		Node curr;
		if (dataset.classes.keySet().size() == 1) {
			curr = new Node(dataset.majorityClass);
			return curr;
		}
		if (attrList.isEmpty()) {
			curr = new Node(dataset.majorityClass);
			return curr;
		}
		curr = id3AttributeSelector(dataset, attrList);

		// make condition here
		attrList.remove(Integer.valueOf(curr.attr));

		for (BranchDecision branch : curr.branches) {
			if (branch.partitionedDataSet.data.isEmpty()) {
				return new Node(dataset.majorityClass);
			} else {
				branch.resultant = buildTree(branch.partitionedDataSet, attrList);
			}
		}

		return curr;
	}

	private static Node id3AttributeSelector(DataSet dataset, List<Integer> attrList) {

		Double infoD = 0.0;
		for (String c : dataset.classes.keySet()) {
			double temp = dataset.classes.get(c) / dataset.data.size();
			infoD -= temp * (Math.log(temp) / Math.log(2));
		}

		/*if(attrList.size() == 1 && attrList.get(0) == 4) {
			System.out.println();
		}*/
		
		//Double maxGain = Double.MIN_VALUE;
		Double maxGain = -1.0;
		int selectedAttr = -1;
		Map<String, DataSet> selectedDatasets = null;
		for (Integer i : attrList) {
			Map<String, DataSet> djs = new HashMap();
			/*if (attrList.indexOf(i) == attrList.size() - 1)
				break;*/
			for (String[] str : dataset.data) {

				if (!djs.containsKey(str[i])) {
					djs.put(str[i], new DataSet());
				}
				djs.get(str[i]).data.add(str);

				if (!djs.get(str[i]).classes.containsKey(str[str.length - 1])) {
					djs.get(str[i]).classes.put(str[str.length - 1], 1.0);
					if (null == djs.get(str[i]).majorityClass) {
						djs.get(str[i]).majorityClass = str[str.length - 1];
					}
				} else {
					djs.get(str[i]).classes.put(str[str.length - 1],
							djs.get(str[i]).classes.get(str[str.length - 1]) + 1);
				}

				if (djs.get(str[i]).classes.get(djs.get(str[i]).majorityClass) < djs.get(str[i]).classes
						.get(str[str.length - 1])) {
					djs.get(str[i]).majorityClass = str[str.length - 1];
				}
			}
			Double infoDA = 0.0;
			for (DataSet dj : djs.values()) {
				double weight = ((double) dj.data.size()) / dataset.data.size();
				Double infoDj = 0.0;
				for (Map.Entry<String, Double> c : dj.classes.entrySet()) {
					double temp = c.getValue() / dj.data.size();
					infoDj -= temp * (Math.log(temp) / Math.log(2));
				}
				infoDA += weight * infoDj;
			}
			Double gain = (infoD - infoDA);
			if (gain > maxGain) {
				maxGain = infoD - infoDA;
				selectedAttr = i;
				selectedDatasets = djs;
			}
		}

		if(selectedAttr == -1)
			System.out.println("ERROR");
		Node result = new Node(selectedAttr);
		for (Map.Entry<String, DataSet> dj : selectedDatasets.entrySet()) {
			BranchDecision branch = new BranchDecision();
			branch.equalTo = dj.getKey();
			branch.partitionedDataSet = dj.getValue();
			result.branches.add(branch);
		}

		// System.out.println(selectedAttr + ":" + maxGain);

		return result;
	}

}
