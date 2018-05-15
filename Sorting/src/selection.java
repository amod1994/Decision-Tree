
public class selection {

	public void selectionSort(int[] a) {
		
		int length = a.length;
		
		for(int i = 0; i < length-1; i++)
		{
			for(int j = i+1; j < length; j++)
			{
				if(a[i] > a[j])
				{
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		
		for(int i = 0; i < length; i++)
		{
			System.out.println(a[i]);
		}
		
	}

}
