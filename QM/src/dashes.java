import java.util.*;
import java.lang.*;

public class dashes {

	public static void main(String[] args) {
		
		System.out.println("Enter size of input");
		Scanner sc = new Scanner(System.in);
		int sz = sc.nextInt();
		System.out.println("Enter number of Input bits");
		int len = sc.nextInt();	
		
		Map<Integer, List<String>> group = new HashMap<Integer, List<String>>();
		List<String> temp1 = new ArrayList<String>();
		List<String> temp2 = new ArrayList<String>();
		
		int key = 0;
		
		for(int i = 0; i<len; i++)
		{

			int ip = sc.nextInt();
			String bin = Integer.toBinaryString(ip);
			String temp = appZero(bin, sz);
			
			int ltemp = temp.length();
			int cnt = 0;
			
			for(int j = 0; j<ltemp; j++)
			{
				if(temp.charAt(j) == '1')
					cnt++;
			}
			
			group.putIfAbsent(cnt, new ArrayList<String>());
			group.get(cnt).add(temp);
			
			
			if (group.containsKey(key) && group.containsKey(++key)) {
				   temp1 = group.get(key);
				   temp2 = group.get(++key);
				 System.out.println("Key : " + key +" value :"+ value);
				 }

			
			/*
			group.forEach((k, v) -> {
			    System.out.print(k + " = ");
			    v.forEach(w -> System.out.print(w + ","));
			    System.out.println();
			});*/
		}
	}
	
	
	
	
	//APPEND ZERO'S
	public static String appZero(String a, int b)
	{
		int numberOfDigits = String.valueOf(a).length();
	      int numberOfLeadingZeroes = b - numberOfDigits;
	      StringBuilder sb = new StringBuilder();
	      if (numberOfLeadingZeroes > 0) {
	         for (int i = 0; i < numberOfLeadingZeroes; i++) {
	            sb.append("0");
	         }
	      }
	      sb.append(a);
	      return sb.toString();
		
	}

}
