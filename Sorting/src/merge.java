
public class merge {
	
	public void sort(int arr[], int left, int right) {
		
		if(left < right)
		{
			int mid = (left+right)/2;
			
			sort(arr, 0, mid);
			sort(arr, mid+1, right);
			
			merger(arr, left, right, mid);
			
		}
		
	}
	
	public void merger(int arr[], int left, int right, int mid)
	{
		
		int n1 = mid-left+1;
		int n2 = right-mid;
		
		int[] lArray = new int[n1];
		int[] rArray = new int[n2];
		
		for(int i = 0; i< n1; ++i)
		{
			lArray[i] = arr[left+i];
		}
		
		for(int j = 0; j<n2; ++j)
		{
			rArray[j] = arr[mid + 1 + j];
		}
		
		
		int i = 0, j= 0;
		int k = left;
		
		while(i<n1 && j<n2)
		{
			if(lArray[i] > rArray[j])
			{
				arr[k] = rArray[j];
				j++;
			}else
			{
				arr[k] = lArray[i];
				i++;
			}
		}
		while (i < n1)
        {
            arr[k] = lArray[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = rArray[j];
            j++;
            k++;
        }
        
        display(arr);
	}

public void display(int[] arr) {
	
	for(int i = 0; i<arr.length; i++)
		System.out.println(arr[i]);
}

}
