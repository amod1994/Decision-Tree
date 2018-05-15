
public class sortingAlgo {

	public static void main(String[] args) {
		
		int[] array = new int[10];
		array[0]=2;
		array[1]=3;
		array[2]=1;
		array[3]=0;
		array[4]=9;
		array[5]=5;
		array[6]=7;
		array[7]=8;
		array[8]=14;
		array[9]=67;
		
		/*selection sc = new selection();
		sc.selectionSort(array);*/
		
		/*bubbleSort bs = new bubbleSort();
		bs.bubbleAlgo(array);*/
		
		/*insertion is = new insertion();
		is.insertionAlgo(array);*/
	
		merge mg = new merge();
		mg.sort(array, 0, array.length);
	}

}
