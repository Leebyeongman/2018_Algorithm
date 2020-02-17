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
		// 노드를 생성합니다.
		Node newNode = new Node(id, num);
		// 새로운 노드의 다음 노드로 해드를 지정합니다.
		newNode.next = head;
		// 헤드로 새로운 노드를 지정합니다.
		head = newNode;
		size++;
		if(head.next == null){
			tail = head;
		}
	}

	public void addLast(String id, int num){
		// 노드를 생성합니다.
		Node newNode = new Node(id, num);
		// 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
		if(size == 0){
			addFirst(id, num);
		} else {
			// 마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
			tail.next = newNode;
			// 마지막 노드를 갱신합니다.
			tail = newNode;
			// 엘리먼트의 개수를 1 증가 시킵니다.
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
			// 탐색을 시작합니다.
			Node temp = head;
			String str = "";
			// 다음 노드가 없을 때까지 반복문을 실행합니다.
			// 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
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
