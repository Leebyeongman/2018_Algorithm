package Insertion_Sort;
import LinkedList.DoublyLinkedList;

public class Insertion_Sort {
	public Object Insertion(DoublyLinkedList insert_list) {
		for (int i = 1; i < insert_list.size(); i++) {
			int standard_value = (int) insert_list.get(i);
			int a = i-1;
			
			while (standard_value < (int) insert_list.get(a) && a >= 0 ) {
				insert_list.add(a, standard_value);
				insert_list.remove(a+2);
				a--;
			}
		}		
		return insert_list;
	}
	
	public void print(DoublyLinkedList insert_list) {
		for (int i = 0; i < insert_list.size(); i++) {
			System.out.println(insert_list.get(i));
		}
	}
}
