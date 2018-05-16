import java.util.*;


public class Node {
	
	int attr = -1;
	String label;
	
	ArrayList<BranchDecision> branches;
	
	Node(String label){
		this.label = label;
		this.branches = new ArrayList<>();
	}
	
	Node(int attr){
		this.attr = attr;
		this.branches = new ArrayList<>();
	}
	
}
