import java.util.ArrayList;
import java.util.List;

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
				
			}
		}
		
		return null;
	}

	private static Node attrSelectionMethod(DataSet dataset, List<Integer> attrList) {
		// TODO Auto-generated method stub
		return null;
	}
}
