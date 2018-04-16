import java.util.*;

public class util {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int[] scanLIS() {
		
		int n = sc.nextInt();
		
		int[] ip = new int[n];
		for(int i = 0; i < n; i++)
			ip[i] = sc.nextInt();
		sc.close();

		return ip;
	}
	
	public static void displayLIS(int[] arr) {
		int max = 0;
		
		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] > arr[i-1])
				max = arr[i];
			else 
				max = arr[i-1];
		}
		System.out.println(max);
	}
	
	public static String[] scanLCS() {
		
		String[] str = new String[2];
		str[0] = sc.nextLine();
		str[1] = sc.nextLine();
		sc.close();
		return str;
	}
	
	public static void displayLCS(int[][] arr, int l1, int l2, ArrayList<Character> al) {
		int max = 0;
		for(int i = 0; i < l1; i++)
			for(int j = 0; j < l2; j++)
				max = arr[i][j] > max ? arr[i][j] : max;
				
		System.out.println(max);
		System.out.println(al);
	}
	
	public static String[] scaneD() {
		
		String[] str = new String[2];
		str[0] = sc.nextLine();
		str[1] = sc.nextLine();
	
		return str;
	}
	
	public static void printeD(int x) {
		System.out.println(x);
	}
	
	public static int[][] scanmCP(int len, int wdt){
		
		int[][] arr = new int[len][wdt];
		
		for(int i = 0; i < len; i++)
			for(int j = 0; j < wdt; j++)
				 arr[i][j] = sc.nextInt(); 
		return arr;
	}

	public static void displayMCP(int x) {
		System.out.println(x);
	}
	
	public static int[] scanCC() {
		System.out.println("Enter Number of Elements including coins and denominations");
		int[] arr = new int[sc.nextInt()];
		for(int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		return arr;
	}
	
	public static void displayCC(int x) {
		System.out.println(x);
	}
	
	public static String[] scanLCSS() {
		System.out.println("Enter Two Strings directly");
		String[] str = new String[2];
		for(int i = 0; i < 2; i++)
			str[i] = sc.nextLine();
		return str;
	}
}
