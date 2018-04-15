import java.util.ArrayList;
import java.util.HashMap;
//import java.util.LinkedList;
import java.util.List;

public class Algorithm {
	HashMap<String, Links> header;
	Node root;
	
	Algorithm(Node root, HashMap<String, Links> header){
		this.header = header;
		this.root = root;
	}
	
	public HashMap<String, List<AllPattern>> fpGrowth() {
		HashMap<String, String> pattern = new HashMap<String, String>();
		
		HashMap<String, List<AllPattern>> result = new HashMap<>();
		//Attribute atb;
		
		String patternStr = null;
		
		for(String str : header.keySet()) {
			patternStr = str;
			//result.put(str, null);
			AllPattern ap = new AllPattern();
			List<Node> link1 = header.get(str).link;
			
			List<AllPattern> sdf = new ArrayList<AllPattern>();
			for(int i = 0; i < link1.size(); i++)
			{	
				Node current = link1.get(i);
				//atb = new Attribute();
				ap.cnt = current.count;
				AllPattern asd = new AllPattern();
				asd.cnt = current.count;
				while(current.parent != null) {
					if(current.parent == root) {
						patternStr = patternStr.concat("--END OF PATTERN--");
						break;
					}else {
						asd.pattern.add(current.parent.name);
						patternStr = patternStr.concat(current.parent.name+",");
						//atb.nodes.add(current.parent.name);
						current = current.parent;
					}
				}
				sdf.add(asd);
			}
			result.put(str, sdf);
			pattern.put(str, patternStr);
			patternStr = null;
		}
		return result;
	}

}
