package Selection_Sort;
import LinkedList.DoublyLinkedList;

public class Selection_Sort {
	public Object Selection(DoublyLinkedList select_list) {
		int min_value;

		for(int i = 0; i < select_list.size()-1; i++) {
			min_value = i;
			for(int j = i+1; j < select_list.size(); j++) {
				if((int) select_list.get(min_value) > (int) select_list.get(j)) {
					min_value = j;
				}
			}
			select_list.add(i, select_list.get(min_value));
			select_list.remove(min_value+1);
		}
		return select_list;
	}

	public void print(DoublyLinkedList select_list) {
		for (int i = 0; i < select_list.size(); i++) {
			System.out.println(select_list.get(i));
		}
	}
}
