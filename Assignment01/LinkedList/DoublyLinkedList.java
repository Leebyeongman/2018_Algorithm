package LinkedList;

public class DoublyLinkedList {
	private Node head; 								// Node head
	private Node tail;								// Node tail
	private int size = 0;

	public void addFirst(Object input) {
		Node newNode = new Node(input);	    		// ��带 ����
		newNode.next = head;		    			// ���ο� ����� ���� ���� ��带 ����

		if (head != null)							// ������ ��尡 �־��ٸ�
			head.prev = newNode;					// ���� ����� ���� ���� ���ο� ��带 ����
		head = newNode;				    			// ���� ���ο� ��带 ����
		size++;

		if (head.next == null) {
			tail = head;
		}
		
	}

	public void addLast(Object input) {
		Node newNode = new Node(input);				// ��带 ����

		if (size == 0) {							// ����Ʈ�� ��尡 ���ٸ� 
			addFirst(input);						// ù��° ��带 �߰��ϴ� �޼ҵ带 ���
		} else {
			tail.next = newNode;				    // tail�� ���� ���� ������ ��带 ����
			newNode.prev = tail;					// ���ο� ����� ���� ���� tail�� ����
			tail = newNode;							// ������ ��带 ����
			size++;						        	// ������Ʈ�� ������ 1 ����
		}
	}

	public void add(int k, Object input) {
		if (k == 0) {								// ���� k�� 0�̶��
			addFirst(input);						// ù��° ��忡 �߰��ϴ� ���̱� ������ addFirst�� ���
		} 
		else {
			Node temp1 = node(k - 1);
			Node temp2 = temp1.next;				// k ��° ��带 temp2�� ����
			Node newNode = new Node(input);			// ���ο� ��带 ����

			temp1.next = newNode;					// temp1�� ���� ���� ���ο� ��带 ����
			newNode.next = temp2;					// ���ο� ����� ���� ���� temp2�� ����
			// temp2�� ���� ���� ���ο� ��带 �����մϴ�.
			if (temp2 != null)
				temp2.prev = newNode;
			// ���ο� ����� ���� ���� temp1�� �����մϴ�.
			newNode.prev = temp1;
			size++;
			// ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̱� ������ tail�� �����մϴ�.
			if (newNode.next == null) {
				tail = newNode;
			}
			
		}
	}

	Node node(int index) {
		// ����� �ε����� ��ü ��� ���� �ݺ��� ū�� ������ ���
		if (index < size / 2) {
			// head���� next�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
			Node x = head;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			// tail���� prev�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
			Node x = tail;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	public Object removeFirst() {
		// ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����մϴ�.
		Node temp = head;
		head = temp.next;
		// �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����ϴ�.
		Object returnData = temp.object;
		temp = null;
		// ����Ʈ ���� ��尡 �ִٸ� head�� ���� ��带 null�� �����մϴ�.
		if (head != null)
			head.prev = null;
		size--;
		return returnData;
	}

	public Object remove(int k) {
		if (k == 0)
			return removeFirst();
		// k-1��° ��带 temp�� �����մϴ�.
		Node temp = node(k - 1);
		// temp.next�� �����ϱ� ���� todoDeleted ������ �����մϴ�.
		Node todoDeleted = temp.next;
		// ���� ��� ��带 ���ῡ�� �и��մϴ�.
		temp.next = temp.next.next;
		if (temp.next != null) {
			// ������ ����� ���� ��带 �����մϴ�.
			temp.next.prev = temp;
		}
		// ������ ����� �����͸� �����ϱ� ���ؼ� returnData�� �����͸� �����մϴ�.
		Object returnData = todoDeleted.object;
		// ������ ��尡 tail�̾��ٸ� tail�� ���� ��带 tail�� �����մϴ�.
		if (todoDeleted == tail) {
			tail = temp;
		}
		// cur.next�� ���� �մϴ�.
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
