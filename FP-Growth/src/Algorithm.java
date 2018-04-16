import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Algorithm {
	HashMap<String, Links> header;
	Node root;
	
	Algorithm(Node root, HashMap<String, Links> header){
		this.header = header;
		this.root = root;
	}
	
	public ArrayList<Result> fpGrowth(int min_sup) {		
		HashMap<String, List<AllPattern>> result = new HashMap<>();
		
		for(String str : header.keySet()) {
			List<Node> link1 = header.get(str).link;
			
			AllPattern ap = new AllPattern();
			
			List<AllPattern> sdf = new ArrayList<AllPattern>();
			for(int i = 0; i < link1.size(); i++)
			{	
				Node current = link1.get(i);
				ap.cnt = current.count;
				
				AllPattern asd = new AllPattern();
				asd.cnt = current.count;
				while(current.parent != null) {
					if(current.parent == root) {
						break;
					}else {
						asd.pattern.add(current.parent.name);
						current = current.parent;
					}
				}
				sdf.add(asd);
			}
			result.put(str, sdf);
		}
		return minSupPattern(result, min_sup);
	}
	
	public ArrayList<Result> minSupPattern(HashMap<String, List<AllPattern>> result, int min_sup) {
		ArrayList<Result> result1 = new ArrayList<Result>();
		
		for(String node : result.keySet()) {
			HashMap<String, Integer> freq = new HashMap<String, Integer>();
			for(int i = 0; i < result.get(node).size(); i++) {
				for(String str : result.get(node).get(i).pattern) {
					if(!freq.containsKey(str)) {
						freq.put(str, 1);
					}else 
						freq.put(str, freq.get(str)+1);
				}
			}
			Result patt = new Result();
			patt.name = node.substring(0, node.length() - 4);;
			
			for(int i = 0; i < result.get(node).size(); i++) {
				for(String str : result.get(node).get(i).pattern) {
					if(freq.get(str) >= min_sup) {
						patt.pattern.add(str.substring(0, str.length() - 4));
					}
				}
			}
			result1.add(patt);
		}
		return result1;
	}
}