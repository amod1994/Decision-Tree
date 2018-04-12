import java.util.*;

public class FP_Tree {	
	Node root = new Node();
	ArrayList<Attribute> dataset;
	
	
	FP_Tree(ArrayList<Attribute> dataset){
		this.dataset = dataset;
	}

	//PROCESS EACH TUPLE FOR CONSTRUCTING TREE
	public void parseTree() {
		for(int i = 0; i < dataset.size(); i++) {
				System.out.println(dataset.get(i).nodes);
				insertNode(dataset.get(i).nodes, root);
		}
		//System.out.println("Done");
	}
	
	//INSERT EACH NODE FROM A TUPLE INTO TREE
	public void insertNode(ArrayList<String> tuple, Node root) {
		Node current = root;

		for(int i = 0; i < tuple.size(); i++) {
			Node newNode = new Node(tuple.get(i));
			
			int index = checkChildPresent(newNode, current); 
			
			if(index == -1) {
				current.childern.add(newNode);
				current = newNode;
			}else  {
				if(index != -1) {
				current = current.childern.get(index);
				current.count++;
				}
			}
		}
	}
	
	//CHECK IF ELEMENT IS PRESENT AS A CHILD OF CURRENT NODE
	public static int checkChildPresent(Node newNode, Node current) {
		for(int i = 0; i < current.childern.size(); i++)
			if(current.childern.get(i).name.equals(newNode.name))
				return i;
		
		return -1;
	}
}


