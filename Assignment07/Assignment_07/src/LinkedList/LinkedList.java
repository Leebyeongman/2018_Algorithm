package LinkedList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import Set.main;

public class LinkedList {
	public Node head;
	public Node tail;
	public int size = 0;

	public class Node{
		public String id;
		public int num;
		public Node parent;
		public Node next;

		public Node(String id, int num) {
			this.id = id;
			this.num = num;
			this.parent = this;
			this.next = null;
		}
	}

	public void addFirst(String id, int num){
		// ��带 �����մϴ�.
		Node newNode = new Node(id, num);
		// ���ο� ����� ���� ���� �ص带 �����մϴ�.
		newNode.next = head;
		// ���� ���ο� ��带 �����մϴ�.
		head = newNode;
		size++;
		if(head.next == null){
			tail = head;
		}
	}

	public void addLast(String id, int num){
		// ��带 �����մϴ�.
		Node newNode = new Node(id, num);
		// ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ带 ����մϴ�.
		if(size == 0){
			addFirst(id, num);
		} else {
			// ������ ����� ���� ���� ������ ��带 �����մϴ�.
			tail.next = newNode;
			// ������ ��带 �����մϴ�.
			tail = newNode;
			// ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
			size++;
		}
	}
	Node node(int index) {
		Node x = head;
		for (int i = 1; i < index; i++)
			x = x.next;
		return x;
	}

	public Node get(int k){
		Node temp = node(k);
		return temp;
	}

	public String toString(String path) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);

			if(head == null){
				bufWriter.write("[]");
				bufWriter.close();
				return "[]";
			}       
			// Ž���� �����մϴ�.
			Node temp = head;
			String str = "";
			// ���� ��尡 ���� ������ �ݺ����� �����մϴ�.
			// ������ ���� ���� ��尡 ���� ������ �Ʒ��� ������ ������ ���� ���ܵ˴ϴ�.
			String a[];
			while(temp != null){
				str = temp.id + "\t" + temp.parent.id+"\n";
				a = str.split("\n");
				bufWriter.write(a[0]);
				bufWriter.newLine();
				temp = temp.next;
			}
			bufWriter.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return path;
	}

	public static Node find_set(Node input) {
		if (input.parent.id.equals(input.id))
			return input;
		else
			return find_set(input.parent);
	}

	public void union(Node S1, Node S2) {
		Node x = find_set(S1);
		Node y = find_set(S2);
		x.parent = y;
	}
}
