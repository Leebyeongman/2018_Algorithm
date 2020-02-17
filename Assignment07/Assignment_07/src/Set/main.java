package Set;

import java.io.IOException;
import File_management.*;
import LinkedList.LinkedList;
import LinkedList.LinkedList.Node;

public class main {
	public static void main(String[] args) throws IOException {
		LinkedList LinkedList = File_read.fileRead("Data.txt"); // File Read
		Node temp = LinkedList.head;
		
		while(temp != null) {
			LinkedList.union(temp, LinkedList.get(temp.num));
			temp = temp.next;
		}
		
		System.out.println(LinkedList.toString("Output1.txt") + " saved");
		
		temp = LinkedList.head;
		while(temp.next != null) {
			LinkedList.union(temp, temp.next);
			temp = temp.next;
		}
		
		System.out.println(LinkedList.toString("Output2.txt") + " saved");
	}
}
