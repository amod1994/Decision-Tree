import java.util.*;

public class main {

	public static void main(String[] args) {
	
		String[] dataset = {"Engineering;1;Richard",
							"HR;2;Erlich",
							"Business;3;Monica",
							"Engineering;4;Dinesh",
							"Engineering;6;Carla",
							"Directors;9;Laurie"
							};
		String[] friendList1 = {"1;2",
								"1;3",
								"1;6",
								"2;4"
								//"3;4"
								};

		
		HashMap<String, ArrayList<Integer>> result = new HashMap<String, ArrayList<Integer>>();
		result = friendList.employeDetails(dataset, friendList1);
		
		for(String keys : result.keySet())
			System.out.println("Deparment Name: " + keys + "\tEmployees in Department: " + result.get(keys).get(0) + "\tEmployess having friends in other department: " + result.get(keys).get(1));
		
	}

}
