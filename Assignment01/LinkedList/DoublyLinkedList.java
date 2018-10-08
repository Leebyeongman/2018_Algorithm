package LinkedList;

public class DoublyLinkedList {
	private Node head; 								// Node head
	private Node tail;								// Node tail
	private int size = 0;

	public void addFirst(Object input) {
		Node newNode = new Node(input);	    		// 노드를 생성
		newNode.next = head;		    			// 새로운 노드의 다음 노드로 헤드를 지정

		if (head != null)							// 기존에 노드가 있었다면
			head.prev = newNode;					// 현재 헤드의 이전 노드로 새로운 노드를 지정
		head = newNode;				    			// 헤드로 새로운 노드를 지정
		size++;

		if (head.next == null) {
			tail = head;
		}
		
	}

	public void addLast(Object input) {
		Node newNode = new Node(input);				// 노드를 생성

		if (size == 0) {							// 리스트의 노드가 없다면 
			addFirst(input);						// 첫번째 노드를 추가하는 메소드를 사용
		} else {
			tail.next = newNode;				    // tail의 다음 노드로 생성한 노드를 지정
			newNode.prev = tail;					// 새로운 노드의 이전 노드로 tail을 지정
			tail = newNode;							// 마지막 노드를 갱신
			size++;						        	// 엘리먼트의 개수를 1 증가
		}
	}

	public void add(int k, Object input) {
		if (k == 0) {								// 만약 k가 0이라면
			addFirst(input);						// 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용
		} 
		else {
			Node temp1 = node(k - 1);
			Node temp2 = temp1.next;				// k 번째 노드를 temp2로 지정
			Node newNode = new Node(input);			// 새로운 노드를 생성

			temp1.next = newNode;					// temp1의 다음 노드로 새로운 노드를 지정
			newNode.next = temp2;					// 새로운 노드의 다음 노드로 temp2를 지정
			// temp2의 이전 노드로 새로운 노드를 지정합니다.
			if (temp2 != null)
				temp2.prev = newNode;
			// 새로운 노드의 이전 노드로 temp1을 지정합니다.
			newNode.prev = temp1;
			size++;
			// 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
			if (newNode.next == null) {
				tail = newNode;
			}
			
		}
	}

	Node node(int index) {
		// 노드의 인덱스가 전체 노드 수의 반보다 큰지 작은지 계산
		if (index < size / 2) {
			// head부터 next를 이용해서 인덱스에 해당하는 노드를 찾습니다.
			Node x = head;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			// tail부터 prev를 이용해서 인덱스에 해당하는 노드를 찾습니다.
			Node x = tail;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	public Object removeFirst() {
		// 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
		Node temp = head;
		head = temp.next;
		// 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
		Object returnData = temp.object;
		temp = null;
		// 리스트 내에 노드가 있다면 head의 이전 노드를 null로 지정합니다.
		if (head != null)
			head.prev = null;
		size--;
		return returnData;
	}

	public Object remove(int k) {
		if (k == 0)
			return removeFirst();
		// k-1번째 노드를 temp로 지정합니다.
		Node temp = node(k - 1);
		// temp.next를 삭제하기 전에 todoDeleted 변수에 보관합니다.
		Node todoDeleted = temp.next;
		// 삭제 대상 노드를 연결에서 분리합니다.
		temp.next = temp.next.next;
		if (temp.next != null) {
			// 삭제할 노드의 전후 노드를 연결합니다.
			temp.next.prev = temp;
		}
		// 삭제된 노드의 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
		Object returnData = todoDeleted.object;
		// 삭제된 노드가 tail이었다면 tail을 이전 노드를 tail로 지정합니다.
		if (todoDeleted == tail) {
			tail = temp;
		}
		// cur.next를 삭제 합니다.
		todoDeleted = null;
		size--;
		return returnData;
	}

	public Object removeLast() {
		return remove(size - 1);
	}

	public int size() {
		return size;
	}

	public Object get(int k) {
		Node temp = node(k);
		return temp.object;
	}
}
