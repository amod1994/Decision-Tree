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

		//Util.printTree(root);

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
			return new Node(dataset.majorityClass);
		}
		if (attrList.isEmpty()) {
			return new Node(dataset.majorityClass);
		}
		
		//curr = ID3.AttributeSelector(dataset, attrList);
		//curr = C45.AttributeSelector(dataset, attrList);
		curr = CART.AttributeSelector(dataset, attrList);
		
		/*make condition here-> moved to attrSelection*/
		//attrList.remove(Integer.valueOf(curr.attr));

		for (BranchDecision branch : curr.branches) {
			if (branch.partitionedDataSet.data.isEmpty()) {
				return new Node(dataset.majorityClass);
			} else {
				branch.resultant = buildTree(branch.partitionedDataSet, attrList);
			}
		}

		return curr;
	}

}
