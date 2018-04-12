import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;


public class Util {
	
	//CALCULATE FREQUECY OF EACH ELEMENT
	public static HashMap<String, Integer> calFreq(String filePath) {
		Scanner in;
		HashMap<String, Integer> freq = new HashMap<String, Integer>();
		
		try {
			
			in = new Scanner(new File(filePath));
			
			//TODO: IF FIRST ROW IS INFORMATION
			//String str = in.next();
		
			while(in.hasNext()) {
				String[] strAttrs = in.next().split(",");
				for (int i = 0; i < strAttrs.length; i++) {
					if (!strAttrs[i].isEmpty()){
						//MAKE EACH ELEMENT UNIQUE
						strAttrs[i] = strAttrs[i].concat("col") + i;
						if(freq.containsKey(strAttrs[i])) {
							freq.put(strAttrs[i], freq.get(strAttrs[i])+1);
						}else 
							freq.put(strAttrs[i], 1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		return freq;
	}

	//READ CSV FILE STORE TUPLES INTO DATABASE
	public static ArrayList<Attribute> readCSV(HashMap<String, Integer> freq, String filePath) {
		
		Scanner in;
		ArrayList<Attribute> dataset = new ArrayList<Attribute>();
		HashMap<String, Integer> tuple = new HashMap<String, Integer>();
		List<Entry<String, Integer>> sortedTuple; 
		
		try {
			
			in = new Scanner(new File(filePath));
			
			/*TODO: IF FIRST ROW IS INFORMATION
			String str = in.next();*/
			
			int lenOfDS = 0;
			
			while(in.hasNext()) {
				dataset.add(new Attribute());
				String[] strAttrs = in.next().split(",");
				for (int i = 0; i < strAttrs.length; i++) {
					if (!strAttrs[i].isEmpty()){
						strAttrs[i] = strAttrs[i].concat("col") + i; 
						tuple.put(strAttrs[i], freq.get(strAttrs[i]));
					}
				}
				sortedTuple = orderElement(tuple);
				
				for(int j = sortedTuple.size()-1; j >= 0; j--)
					dataset.get(lenOfDS).nodes.add(sortedTuple.get(j).getKey());
				
				lenOfDS++;
				tuple.clear();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		return dataset;
	}
	
	//SORT HASHMAP BASED ON VALUE
	public static List<Entry<String, Integer>> orderElement(HashMap<String, Integer> tuple) {
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(tuple.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {				
				return o1.getValue().compareTo(o2.getValue());
			}			
		});
		return list;
	}
	
	//DISPLAY DATABASE
	public static void display(ArrayList<Attribute> list) {
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.get(i).nodes.size(); j++) {
				System.out.print(list.get(i).nodes.get(j) + "  ");
			}
			System.out.println();
		}
	}
}
