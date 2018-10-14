package Counting_Sort;

public class countingSort {
	public static int[] countingSort(int[] arr) {
		int maxValue = 0;
		int length = arr.length;

		/* search maxValue in Not Arranged array*/ 
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxValue)
				maxValue = arr[i];
		}

		/* create array for counting */
		int[] countArr = new int[maxValue+1];

		/* counting */
		for (int i = 0; i < length; i++) {
			countArr[arr[i]]++;
		}

		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i-1];
		}

		/* create array for sort */
		int[] sortArr = new int[length];
		
		/* sort start */
		for (int i = 0; i < sortArr.length; i++) {
			int index = countArr[arr[i]]; // search index
			sortArr[index-1] = arr[i]; // insert in sort Array
			countArr[arr[i]]--; // minus count
		}
		return sortArr;
	}
}


