package peakFinder;

import java.util.*;

public class mainActivity {

	public static void main(String[] args) {
	
		int[] a = new int[10];
		
		for(int i = 0; i<10; i++)
			a[i] = 1+i;
		
		
		int mid = a.length;
		int start = 0;
		int index = peak(a, start, mid);
		System.out.print(a[index]);
	}
	
	public static int peak(int[] a, int strt, int end) {
		int mid = strt+end/2;
		
		if(a[mid] < a[mid-1])
		{
			end = mid - 1;
			peak(a, strt, end);
		}
		else if(a[mid] > a[mid+1])
		{
			strt = mid;
			peak(a, strt, end);
		}
		return mid;
	}

}
