import java.util.*;

public class FP_Growth {

	public static void main(String[] args) {
		
		final String filePath = "D:\\SEM-II\\Learning Systems-ESE589-Doboli\\Project 2\\self.csv";
		final int minSup = 1;
		final int minSupPatt = 1;
		ArrayList<Result> pattern;
		Model model;
		
		//COUNT FREQUENCY OF EACH ELEMENT
		HashMap<String, Integer> freq = Util.calFreq(filePath);
		//Util.displayfreq(freq);
		
		//STORE VALUES IN DATASET AFTER SORTING THEM ACCORDING TO FREQUENCY ------IF NUMBER GRETERE THAN MINSUP---------
		ArrayList<Attribute> dataset = Util.readCSV(freq, filePath, minSup);
		
		//CONSTRUCT FP_TREE
		FP_Tree constructFPTree = new FP_Tree(dataset);
		
		//CONTAINS COMPLETE FP_TREE AND HEADER TABLE
		model = constructFPTree.parseTree();
		//Util.displayTree(model.root);
		
		//FP GROWTH ALGORITHM
		Algorithm fpGrowth = new Algorithm(model.root, model.header);
		pattern = fpGrowth.fpGrowth(minSupPatt);
		
		//PRINT PATTERN
		Util.displayPatt(pattern);
		
		//PRINT SORTED DATASET
		//Util.display(dataset);
	}
}

//TODO: HEADER SORTED/ UNSORTED
