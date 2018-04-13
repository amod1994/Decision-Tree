import java.util.*;


public class Node {
	
	String name;
	int count;
	Node parent;
	ArrayList<Node> childern;
	boolean endOfTuple;
	
	
	Node(String name){
		this.name = name;
		this.count = 1;
		this.endOfTuple = false;
		this.parent = null;
		this.childern = new ArrayList<>();
	}
	
	Node(){
		this.name = "root";
		this.count = 1;
		this.endOfTuple = false;
		this.parent = null;
		this.childern = new ArrayList<>();
	}
	
}
