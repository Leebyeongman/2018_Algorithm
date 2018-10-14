package Max_Heap_Sort;

public class maxHeap {
	
	private int[] arr;
	private int size;

	public maxHeap(int[] arr) {
		this.arr = arr;
		this.size = arr.length;
	}
	
	// n: ������ ���� ����, i�� ������ ���� ��� �ε���
	public static void build_recu_max_heap(int[] a, int i, int n) { 
		if(i >= n/2) // ��������̸�
			return;
		build_recu_max_heap(a, 2*i+1, n);
		build_recu_max_heap(a, 2*i+2, n);
		heapify(a,i,n);
	}
	
	public static int[] heapSort(int[] arr) {
		int length = arr.length;
		build_recu_max_heap(arr, 0, length);
		for (int i = length-1; i >= 1; i--) {
			swap(arr, 0, i);
			length-=1;
			heapify(arr, 0, length);
		}
		return arr;
	}

	public static void heapify(int[] a, int i, int n) {
		int temp = a[i];
		while(i < n/2) // ������ �ƴ� ����
		{
			int j = 2*i +1; // ���� �ڽ�
			if(j + 1 < n && a[j +1] > a[j])
				++j;
			if(a[j] < temp) // ���� �ڽ��� �θ𺸴� ������
				break;
			a[i] = a[j]; // ���� �ڽ��� �θ���� 
			i = j;
			a[i] = temp; // �� �ٲ��ֱ�
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
