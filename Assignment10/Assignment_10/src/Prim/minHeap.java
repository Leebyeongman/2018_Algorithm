package Prim;

import java.util.ArrayList;

public class minHeap {
	private ArrayList<Graph> arr;
	private int size;
	
	public minHeap(ArrayList<Graph> arr) {
		this.arr = arr;
		this.size = arr.size();
	}
	
	// n: 히프의 원소 개수, i는 마지막 내부 노드 인덱스
	public static void build_recu_min_heap(ArrayList<Graph> arr, int i, int n) { 
		if(i >= n/2) // 리프노드이면
			return;
		build_recu_min_heap(arr, 2*i+1, n);
		build_recu_min_heap(arr, 2*i+2, n);
		heapify(arr,i,n);
	}
	
	public static ArrayList<Graph> heapSort(ArrayList<Graph> arr) {
		int length = arr.size();
		build_recu_min_heap(arr, 0, length);
		for (int i = length-1; i >= 1; i--) {
			swap(arr, 0, i);
			length -= 1;
			heapify(arr, 0, length);
		}
		return arr;
	}

	public static void heapify(ArrayList<Graph> arr, int i, int n) {
		Graph temp = arr.get(i);
		while(i < n/2) {// 리프가 아닌 동안
			int j = 2*i +1; // 왼쪽 자식
			if(j + 1 < n && arr.get(j+1).getkey() > arr.get(j).getkey())
				++j;
			if(arr.get(j).getkey() < temp.getkey()) // 왼쪽 자식이 부모보다 크면
				break;
			arr.add(i, arr.remove(j)); // 왼쪽 자식을 부모노드로
			arr.remove(i+1);
			i = j;
			arr.add(i, temp);
		}
	}
	
	public static Graph remove(ArrayList<Graph> arr) {
		return arr.remove(0); 
	}
	
	public static void swap(ArrayList<Graph> arr, int i, int j) {
		Graph temp = arr.get(i);
		arr.add(i, arr.remove(j));
		arr.remove(i+1);
		arr.add(j, temp);
	}
}