package Quick_Sort;
import java.util.Random;

public class Quick_Sort {
	public static int[] Quicksort(int[] Array, int start, int end) {
		if(start < end) {
			int p = partition(Array, start, end);
			Quicksort(Array, start, p-1);
			Quicksort(Array, p+1, end);
		}
		return Array;
	}
	
	public static int[] Quicksort_useRandom(int[] Array, int start, int end) {
		if(start < end) {
			int p = randomizePartition(Array, start, end);
			Quicksort(Array, start, p-1);
			Quicksort(Array, p+1, end);
		}
		return Array;
	}
	
	public static int partition(int[] Array, int start, int end) {
		int pivot = Array[end];
		int i = start-1;

		for(int j=start; j < end; j++) {
			if(Array[j] <= pivot) {
				i++;
				int tmp = Array[i];
				Array[i] = Array[j];
				Array[j] = tmp;
			}
		}
		int tmp = Array[i+1];
		Array[i+1] = Array[end];
		Array[end] = tmp;
		return i+1;
	}
	
	public static int randomizePartition(int[] Array, int start, int end) {
		Random random = new Random();
		int i = random.nextInt(end - start + 1) + start;
		int pivot = Array[i];
		Array[i] = Array[end];
		Array[end] = pivot;
		
		return partition(Array, start, end);
	}
}
