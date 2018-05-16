import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static final String filePath = "D:\\SEM-II\\Learning Systems-ESE589-Doboli\\Project 2\\zoo.csv";

	public static void main(String[] args) {
		
		DataSet dataset = Util.readCSV(filePath);
		
		
		
	}
	
	public static Node buildTree(DataSet dataset, List<Integer> attrList) {
		Node curr;
		if(dataset.classes.keySet().size() < 2) {
			
		}
		if(attrList.isEmpty()) {
			curr = new Node(dataset.majorityClass);
			return curr;
		}
		curr = attrSelectionMethod(dataset, attrList);
		
		//make condition here
		attrList.remove(curr.attr);
		
		for (BranchDecision branch : curr.branches) {
			if(branch.partitionedDataSet.data.isEmpty()) {
				return new Node(dataset.majorityClass);
			}
			else {
				branch.resultant = buildTree(branch.partitionedDataSet, attrList);
			}
		}
		
		return curr;
	}

	private static Node attrSelectionMethod(DataSet dataset, List<Integer> attrList) {

		Double infoD = 0.0;
		for (String c : dataset.classes.keySet()) {
			double temp = dataset.classes.get(c)/dataset.data.size();
			infoD -= temp*Math.log(temp); 
		}
		
		Double maxGain = Double.MIN_VALUE;
		int selecteedAttr = -1;
		for (Integer i : attrList) {
			Map<String, Integer> attrClassCount = new HashMap();
			Map<String, DataSet> djs = new HashMap();
			if (attrList.indexOf(i) == attrList.size() - 1)	break;
			for (String[] str : dataset.data) {
				if (!djs.containsKey(str[i])) {
					djs.put(str[i], new DataSet());
				}
				djs.get(str[i]).data.add(str);
				
				String tAtCl = str[i] + "," + str[attrList.size() - 1];
				if (!attrClassCount.containsKey(tAtCl)) {
					attrClassCount.put(tAtCl, 1);
				} else {
					attrClassCount.put(tAtCl, attrClassCount.get(tAtCl) + 1);
				}
			}
			Double infoDA = 0.0;
			for (String dj : djs.keySet()) {
				double weight = djs.get(dj).data.size() / dataset.data.size();
				Double infoDj = 0.0;
				for (String c : dataset.classes.keySet()) {
					String tAtCl = dj + "," + c;
					if(attrClassCount.containsKey(tAtCl)) {
						double temp = attrClassCount.get(tAtCl)/djs.get(dj).data.size();
						infoDj -= temp*Math.log(temp); 
					}
				}
				infoDA += weight * infoDj;
			}
			if(infoD - infoDA > maxGain) {
				maxGain = infoD - infoDA;
				selecteedAttr = i;
			}
		}

		
		
		
		return null;
	}
}
