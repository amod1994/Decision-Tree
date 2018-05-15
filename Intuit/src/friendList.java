import java.util.*;

public class friendList {

	
	public static HashMap<String, ArrayList<Integer>> employeDetails(String[] dataset, String[] friendList){
		
		HashMap<String, ArrayList<Integer>> dataset1 = new HashMap<String, ArrayList<Integer>>();
		HashMap<Integer, Integer> flag = new HashMap<Integer, Integer>();
		
		
		insertDetails(dataset1, flag, dataset);
		dataset1 = countFriends(dataset1, flag, friendList);
		
		return dataset1;
	}
	
	public static void setFlag(HashMap<Integer, Integer> flag, int empID) {
		flag.put(empID, flag.get(empID)+1);
		
	}
	public static boolean checkFlag(HashMap<Integer, Integer> flag, int empID) {
		System.out.println(flag.get(empID) > 0 ? true : false);
		return flag.get(empID) > 0 ? true : false;
	}
	
	public static void insertDetails(HashMap<String, ArrayList<Integer>> dataset, HashMap<Integer, Integer> flag, String[] empDetails) {
		
		for(int i = 0; i < empDetails.length; i++)
		{
			String[] val = empDetails[i].split(";");
			if(!dataset.containsKey(val[0]))
			{
				dataset.put(val[0], new ArrayList<Integer>());
				dataset.get(val[0]).add(1);
				dataset.get(val[0]).add(0);
				dataset.get(val[0]).add(Integer.parseInt(val[1]));
				flag.put(Integer.parseInt(val[1]), 0);
		
			}else if(dataset.containsKey(val[0])) {
				dataset.get(val[0]).set(0, dataset.get(val[0]).get(0)+1);
				dataset.get(val[0]).add(Integer.parseInt(val[1]));
				flag.put(Integer.parseInt(val[1]), 0);
			}
		}
	}
	
	public static HashMap<String, ArrayList<Integer>> countFriends(HashMap<String, ArrayList<Integer>> dataset, HashMap<Integer, Integer> flag, String[] friendList) {
		
		for(int i = 0; i < friendList.length; i++)
		{
			String[] val = friendList[i].split(";");
			
			for(String key : dataset.keySet()) {
				
				ArrayList<Integer> al = dataset.get(key);
				Integer[] arr = new Integer[al.size()];
				arr = al.toArray(arr);
				for(int  j = 2; j < al.size()-1; j++) {
					if((al.contains(val[0]) == true)) {
						
						if(checkFlag(flag, Integer.parseInt(val[0])) == false) {
							setFlag(flag, Integer.parseInt(val[0]));
							dataset.get(key).set(1, dataset.get(key).get(1)+1);
						}
						for(String keys : dataset.keySet()) {
							
							ArrayList<Integer> al1 = dataset.get(keys);
							for(int  k = 2; k < al1.size()-1; k++)
							if(al.contains(val[1])){
								if(checkFlag(flag, Integer.parseInt(val[1])) == false) {
									setFlag(flag, Integer.parseInt(val[1]));
									dataset.get(keys).set(1, dataset.get(key).get(1)+1);
								}
							}
						}
					}
					
					
						if((!al.contains(val[0]) && al.contains(val[1]))) {
						
						if(checkFlag(flag, Integer.parseInt(val[1])) == false) {
							setFlag(flag, Integer.parseInt(val[1]));
							dataset.get(key).set(1, dataset.get(key).get(1)+1);
						}
						for(String keys : dataset.keySet()) {
							
							ArrayList<Integer> al1 = dataset.get(keys);
							for(int  k = 2; k < al1.size()-1; k++)
							if(al.contains(val[0])){
								if(checkFlag(flag, Integer.parseInt(val[0])) == false) {
									setFlag(flag, Integer.parseInt(val[0]));
									dataset.get(keys).set(1, dataset.get(key).get(1)+1);
								}
							}
						}
					}
					
			//	}
/*				
				
				
				
				
				
				
				
				
				
				
				if(dataset.get(key).contains(Integer.parseInt(val[0]))) {
					if(!dataset.get(key).contains(Integer.parseInt(val[1]))) {
						
						if(checkFlag(flag, Integer.parseInt(val[0])) == false) {
							setFlag(flag, Integer.parseInt(val[0]));
							dataset.get(key).set(1, dataset.get(key).get(1)+1);
						}
						for(String keys : dataset.keySet()) {
							if(dataset.get(keys).contains(Integer.parseInt(val[1]))) {
								if(checkFlag(flag, Integer.parseInt(val[1])) == false) {
									setFlag(flag, Integer.parseInt(val[1]));
									System.out.println(dataset.get(key).get(1));
									System.out.println((dataset.get(key).get(1))+1);
									dataset.get(keys).set(1, dataset.get(key).get(1)+1);
								}
							}
						}
					}
				}
				
				if(dataset.get(key).contains(Integer.parseInt(val[1]))) {
					if(!dataset.get(key).contains(Integer.parseInt(val[0]))) {
						
						if(checkFlag(flag, Integer.parseInt(val[1])) == false) {
							setFlag(flag, Integer.parseInt(val[1]));
							dataset.get(key).set(1, dataset.get(key).get(1)+1);
						}
						for(String keys : dataset.keySet()) {
							if(dataset.get(keys).contains(Integer.parseInt(val[0]))) {
								if(checkFlag(flag, Integer.parseInt(val[0])) == false) {
									setFlag(flag, Integer.parseInt(val[0]));
									dataset.get(keys).set(1, dataset.get(key).get(1)+1);
								}
							}
						}
					}
				}

			}
		}*/
		
	}
}
		return dataset;
	}
}

