
public class bubbleSort {
	
	public void bubbleAlgo(int[] ip) {
		
		int[] a = new int[10];
		a = ip;
		
		int length = a.length;
		int temp;

		for(int i = 0; i < length; i++)
		{
			for(int j = 0; j < length-i-1; j++)
			{
				if(a[j] > a[j+1])
				{
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for(int x = 0; x < length; x++)
			System.out.println(a[x]);
	}
}
