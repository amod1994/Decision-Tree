import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Algorithm {
	HashMap<String, Links> header;
	Node root;
	
	Algorithm(Node root, HashMap<String, Links> header){
		this.header = header;
		this.root = root;
	}
	
	public HashMap<String, String> fpGrowth() {
		HashMap<String, String> pattern = new HashMap<String, String>();
		String patternStr = null;
		
		for(String str : header.keySet()) {
			patternStr = str;
			List<Node> link1 = header.get(str).link;
			
			for(int i = 0; i < link1.size(); i++)
			{
				Node current = link1.get(i);
				
				while(current.parent != null) {
					if(current.parent == root) {
						patternStr = patternStr.concat("--END OF PATTERN--");
						break;
					}else {
						patternStr = patternStr.concat(current.parent.name);
						current = current.parent;
					}
				}
			}
			pattern.put(str, patternStr);
			patternStr = null;
		}
		return pattern;
	}

}
