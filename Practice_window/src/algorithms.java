import java.util.*;

public class algorithms {

	public static void longestIncreasingSubSequence() {
		int[] ip = util.scanLIS();
		int[] arr = new int[ip.length];
		for(int i = 0; i < ip.length; i++)
			arr[i] = 1;

		int next = 1;
		int prev = 0;
		
		while(next < ip.length) {
			while(prev < next) {
				if(ip[next] > ip[prev])
				{
					arr[next] = arr[prev] + 1;
					prev++;
				}else prev++;
			}
			prev = 0;
			next++;
		}	
		util.displayLIS(arr);
	}
	
	
	public static void longestCommonSubSequence(){
		String[] str = util.scanLCS();
		
		int[][] count = new int[str[0].length()+1][str[1].length()+1];
		ArrayList<Character> al = new ArrayList<Character>();
		
		for(int i = 0; i<str[0].length(); i++)
		{
			for(int j = 0; j<str[1].length(); j++)
			{	
				if(str[0].charAt(i) == str[1].charAt(j)) {
					if(i == 0 || j == 0) {
						count[i][j] =  1;
						al.add(str[0].charAt(i));
					}else {
						count[i][j] = count[i-1][j-1]+1;
						// al.add(str[0].charAt(i));
					}
				}else
					count[i][j] = 0;			}
		}
		
		util.displayLCS(count, str[0].length(), str[1].length(), al);
		
	}
	
	
	public static void editDistance() {
		String[] str = util.scaneD();
		
		int[][] arr = new int[str[0].length()+1][str[1].length()+1];
		
		for(int i = 0; i <= str[0].length(); i++) {
			for(int j = 0; j <= str[1].length(); j++) {
				
				if(i == 0)
					arr[i][j] = j;
				else if(j == 0)
					arr[i][j] = i;
				
				else if(str[0].charAt(i-1) == str[1].charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1];
				}else if(str[0].charAt(i-1) != str[1].charAt(j-1)) {
					arr[i][j] = 1 + min(arr[i-1][j], arr[i][j-1], arr[i-1][j-1]);
				}
			}
		}
		
		util.printeD(arr[str[0].length()][str[1].length()]);
	}
	
	public static int min(int x, int y, int z) {
		if(x <= y && x <= z)return x;
		else if(y <= x && y <= z) return y;
		else return z;
	}
	
	
	public static void minCostPath(int len, int wdt) {
		int[][] arr = util.scanmCP(len, wdt);
		int temp[][] = new int[len+1][wdt+1];
        int sum = 0;
        for(int i=1; i <= len; i++){
            temp[0][i] = arr[0][i-1];
        }
        for(int i=1; i <= wdt; i++){
            temp[i][0] = arr[i-1][0];
        }
        
        
        for(int i=1; i <= len; i++){
            for(int j=1; j <= wdt; j++){
                temp[i][j] = arr[i-1][j-1] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);
            }
        }
		util.displayMCP(temp[len][wdt]);
	}
	
	
	public static void coinChange() {
		int[] arr = util.scanCC();
		int  m = arr[0];
		int[] S = new int[arr.length-1];
		for(int i = 1; i<arr.length; i++)
			S[i-1] = arr[i];
		
		int[][] table = new int[m+1][S.length];
		
		for (int i=0; i<S.length; i++)
			table[0][i] = 1;

		for (int i = 1; i < m+1; i++)
		{
			for (int j = 0; j < S.length; j++)
			{
				int x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;
				int y = (j >= 1)? table[i][j-1]: 0;

				table[i][j] = x + y;
			}
		}
		util.displayCC(table[m][S.length-1]);
	}
	
	public static void longestCommonSubString() {
		String[] ip = util.scanLCSS();
		String one = ip[0];
		String two = ip[1];
		
		int lOne = one.length();
		int lTwo = two.length();
		int[][] cost = new int[lOne+1][lTwo+1];
		
		for(int i = 0; i < lOne; i++)
			cost[i][0] = 0;
		for(int j = 0; j < lTwo; j++)
			cost[0][j] = 0;
		
		//cost[0][0] = 1;
		
		for(int i = 1; i < lOne+1; i++)
			for(int j = 1; j < lTwo+1; j++) {
				if(one.charAt(i-1) == two.charAt(j-1)) {
					cost[i][j] = cost[i-1][j-1] + 1;
				}else
					cost[i][j] = max(cost[i-1][j-1], cost[i-1][j], cost[i][j-1]);
			}
		util.displayCC(cost[lOne][lTwo]);
	}
	
	public static int max(int x, int y, int z) {
		if(x > y && x > z) return x;
		else if(y > x && y > z) return y;
		else return z;		
	}
}
