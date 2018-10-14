package Min_Heap_Sort;

public class minHeap {
	
	private int[] arr;
	private int size;

	public minHeap(int[] arr) {
		this.arr = arr;
		this.size = arr.length;
	}
	
	// n: ������ ���� ����, i�� ������ ���� ��� �ε���
	public static void build_recu_min_heap(int[] arr, int i, int n) { 
		if(i >= n/2) // ��������̸�
			return;
		build_recu_min_heap(arr, 2*i+1, n);
		build_recu_min_heap(arr, 2*i+2, n);
		heapify(arr,i,n);
	}
	
	public static int[] heapSort(int[] arr) {
		int length = arr.length;
		build_recu_min_heap(arr, 0, length);
		for (int i = length-1; i >= 1; i--) {
			swap(arr, 0, i);
			length -= 1;
			heapify(arr, 0, length);
		}
		return arr;
	}

	public static void heapify(int[] arr, int i, int n) {
		int temp = arr[i];
		while(i < n/2) // ������ �ƴ� ����
		{
			int j = 2*i +1; // ���� �ڽ�
			if(j + 1 < n && arr[j +1] < arr[j])
				++j;
			if(arr[j] > temp) // ���� �ڽ��� �θ𺸴� ũ��
				break;
			arr[i] = arr[j]; // ���� �ڽ��� �θ���� 
			i = j;
			arr[i] = temp; // �� �ٲ��ֱ�
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
