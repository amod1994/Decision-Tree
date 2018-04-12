import java.util.*;


public class Node {
	
	String name;
	int count;
	ArrayList<Node> childern;
	boolean endOfTuple;
	
	Node(String name){
		this.name = name;
		this.childern = new ArrayList<>();
		this.count = 1;
		this.endOfTuple = false;
	}
	
	Node(){
		this.name = "root";
		this.childern = new ArrayList<>();
		this.count = 1;
		this.endOfTuple = false;
	}
	
}
