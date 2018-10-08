package Merge_Sort;

import java.util.Arrays;

public class Merge_Sort {
	public static final int insertStart = 15; // variable for insertion start 
	public static int[] Mergesort(int[] Array, int left, int right) {
		if (right - left > insertStart) {
	        int mid = (left + right) / 2;
	        Mergesort(Array, left, mid);
	        Mergesort(Array, mid + 1, right);
	        Merge(Array, left, mid, right);
	    } 
		else {
	        insertionSort(Array, left, right);
	    }
		return Array;
	}

	public static void Merge(int[] Array, int left, int mid, int right) {
		int n1 = mid - left + 1;
	    int n2 = right - mid;
	    int[] LA = Arrays.copyOfRange(Array, left, mid +1);
	    int[] RA = Arrays.copyOfRange(Array, mid+1, right +1);
	    int RIDX = 0;
	    int LIDX = 0;
	    
	    for (int i = left; i < right - left + 1; i++) {
	        if (RIDX == n2) {
	            Array[i] = LA[LIDX];
	            LIDX++;
	        } else if (LIDX == n1) {
	        	Array[i] = RA[RIDX];
	            RIDX++;
	        } else if (RA[RIDX] > LA[LIDX]) {
	        	Array[i] = LA[LIDX];
	            LIDX++;
	        } else {
	        	Array[i] = RA[RIDX];
	            RIDX++;
	        }
	    }
	}

	public static void insertionSort(int Array[], int left, int right) {
	    for (int i = left; i < right; i++) {
	        int tempVal = Array[i + 1];
	        int j = i + 1;
	        while (j > left && Array[j - 1] > tempVal) {
	        	Array[j] = Array[j - 1];
	            j--;
	        }
	        Array[j] = tempVal;
	    }
	}
}
