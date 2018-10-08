package Bubble_Sort;

import LinkedList.DoublyLinkedList;

public class Bubble_Sort {
	public Object Bubble(DoublyLinkedList bubble_list) {
		for(int i = 0; i < bubble_list.size(); i++) {
            for (int j = 0; j < bubble_list.size()-1; j++) {
                if((int)bubble_list.get(j) > (int)bubble_list.get(j+1)) {
                	bubble_list.add(j+2, bubble_list.get(j));
                	bubble_list.remove(j);
                }
            }
        }
		return bubble_list;
	}

	public void print(DoublyLinkedList bubble_list) {
		for (int i = 0; i < bubble_list.size(); i++) {
			System.out.println(bubble_list.get(i));
		}		
	}

}
