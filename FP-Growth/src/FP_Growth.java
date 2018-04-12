import java.util.*;

public class FP_Growth {

	public static void main(String[] args) {
		
		final String filePath = "D:\\SEM-II\\Learning Systems-ESE589-Doboli\\Project 2\\self.csv";
		
		//COUNT FREQUENCY OF EACH ELEMENT
		HashMap<String, Integer> freq = Util.calFreq(filePath);
		
		//STORE VALUES IN DATASET AFTER SORTING THEM ACCORDING TO FREQUENCY
		ArrayList<Attribute> dataset = Util.readCSV(freq, filePath);
		
		//CONSTRUCT FP_TREE
		FP_Tree constructFPTree = new FP_Tree(dataset);
		constructFPTree.parseTree();
		
		//PRINT SORTED DATASET
		Util.display(dataset);
	}

}
