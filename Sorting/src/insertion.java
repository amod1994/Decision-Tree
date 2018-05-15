
public class insertion {
	
	public void insertionAlgo(int[] a) {
		
		for(int i = 1; i < a.length; ++i)
		{
			int j = i-1;
			int key = a[i];
				while(j>=0 && a[j] > key)
				{
					a[j+1] = a[j];
	                j = j-1;
				}
				a[j+1] = key;
		}
		
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
		
	}

}
