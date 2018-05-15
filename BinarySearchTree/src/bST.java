//https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
public class bST {
	
	Node root = null;
	
	public void insert(int n) {
		Node newNode = new Node(n);
		
		if(root == null)
		{
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
			
			while(true) {
				parent = current;
				if(n < current.data)
				{
					current = current.left;
					if(current == null)
					{
						parent.left = newNode;
						return;
					}
				}else if(n > current.data)
				{
					current = current.right;
					if(current == null)
					{
						parent.right = newNode;
						return;
					}
				}
			}
	}
	
	
	
	public void display(Node root) {
		
		if(root != null)
		{
			System.out.println(root.data);
			display(root.left);
			display(root.right);
			
		}
		
	}
	
	public void delete(int n) {
		Node current = root;
		Node parent = root;
		
		while(current.data != n) {
		parent = current;
			if(current.data < n) {
				current = current.right;
			}
			else//(current.data > n) {
				current = current.left;
			//}
		}
			if(current.left == null && current.right == null) {
				if(parent.left.data == n) {
					parent.left = null;
				}else 
					parent.right = null;
		}else if(current.left == null && current.right != null)
			{
				if(parent.left == current) {
					parent.left = current.right;
				}else
					parent.right = current.right;
			}
			else if(current.left != null && current.right == null) {
				if(parent.left == current) {
					parent.left = current.left;
				}else
					parent.right = current.left;
			}else if(current.left != null && current.right != null) {
				Node rmvCurrent = current.right;
				
				if(parent.left == current) {
					while(rmvCurrent.left != null) {
					
						rmvCurrent = rmvCurrent.left;
					}
					System.out.println(rmvCurrent.data);
					int a = rmvCurrent.data;
					delete(rmvCurrent.data);
					current.data = a;
				}else{
						while(rmvCurrent.left != null) {
						
							rmvCurrent = rmvCurrent.right;
						}
						System.out.println(rmvCurrent.data);
						int a = rmvCurrent.data;
						delete(rmvCurrent.data);
						current.data = a;
					}	
				//}
				
		}
	}
}
