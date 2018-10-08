package LinkedList;

public class Node {
	
	// 데이터가 저장될 필드
	public Object object;
	
	// 다음 노드를 가리키는 필드
	public Node prev;
	public Node next;
		
	public Node(Object object){
		this.object = object;
		this.prev = this;
		this.next = this;
	}
	
	public Node(Object object, Node prev, Node next){
		this.object = object;
		this.prev = prev;
		this.next = next;
	}
}
