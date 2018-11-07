package Red_Black_Tree;

import Red_Black_Tree.RedBlackNode;

public class RedBlackTree {
	public RedBlackNode current; 
	public RedBlackNode parent;
	public RedBlackNode grand_parent;
	public RedBlackNode great_grand_parent;
	public RedBlackNode root;
	public static RedBlackNode NIL;

	// Red - false	Black - true
	static final boolean Red = false;
	static final boolean Black = true;

	static {
		NIL = new RedBlackNode(0);
		NIL.left = NIL;
		NIL.right = NIL;
	}

	public RedBlackTree(int key) {
		root = new RedBlackNode(key);
		root.left = NIL;
		root.right = NIL;
	}

	public boolean isEmpty() {
		if(root.right == NIL)
			return true;
		return false;
	}

	public void insert(int key) {
		current = parent = grand_parent = root;
		NIL.element = key;

		while (current.element != key) {	// 현재노드의 값이 key와 같지 않으면        
			great_grand_parent = grand_parent;	// 할아버지를 증조로
			grand_parent = parent; 	// 부모를 할아버지로
			parent = current;		// 현재를 부모로
			if (key < current.element)	// 현재노드의 값이 key보다 작으면
				current = current.left;	// 현재노드의 왼쪽으로
			else
				current = current.right;	// 현재노드의 오른쪽으로	
			if (current.left.color == Red && current.right.color == Red) // 현재노드의 왼/오른쪽의 색이 Red이면 
				rebalance(key); // 재배치
		}
		if (current != NIL) // 현재노드가 NIL이 아니라면
			return;	// 함수 종료
		current = new RedBlackNode(key, NIL, NIL); // 삽입할 노드 생성
		if (key < parent.element) // 부모의 값이 key보다 크면
			parent.left = current; // 현재노드를 부모의 왼쪽에
		else	// 작으면
			parent.right = current;	// 현재노드를 부모의 오른쪽에        
		rebalance(key); // 재배치
	}

	private void rebalance(int key) {
		current.color = Red;
		current.left.color = Black; // 리프는 블랙
		current.right.color = Black; // 리프는 블랙

		if (parent.color == Red) {
			grand_parent.color = Red;
			if (key < grand_parent.element != key < parent.element)
				parent = rotate(key, grand_parent);
			current = rotate(key, great_grand_parent);
			current.color = Black;
		}
		root.right.color = Black; 
	}

	private RedBlackNode rotate(int key, RedBlackNode parent) {
		if (key < parent.element)
			if (key < parent.left.element)
				return parent.left = rotateLeftChild(parent.left);
			else
				return parent.left = rotateRightChild(parent.left);
		else
			if (key < parent.right.element)
				return parent.right = rotateLeftChild(parent.right);
			else
				return parent.right = rotateRightChild(parent.right);
	}

	/* Rotate tree left child */
	private RedBlackNode rotateLeftChild(RedBlackNode key_1) {
		RedBlackNode key_2 = key_1.left;
		key_1.left = key_2.right;
		key_2.right = key_1;
		return key_2;
	}

	/* Rotate tree right child */
	private RedBlackNode rotateRightChild(RedBlackNode key_2) {
		RedBlackNode key_1 = key_2.right;
		key_2.right = key_1.left;
		key_1.left = key_2;
		return key_1;
	}

	public boolean search(int key) {
		return search(root.right, key);
	}
	private boolean search(RedBlackNode root, int key) {
		boolean find = false;
		while ((root != NIL) && !find) {
			int rval = root.element;
			if (key < rval)
				root = root.left;
			else if (key > rval)
				root = root.right;
			else {
				find = true;
				break;
			}
			find = search(root, key);
		}
		return find;
	}

	public void inorder() {
		inorder(root.right);
	}
	private void inorder(RedBlackNode root) {
		if (root != NIL) {
			inorder(root.left);
			char color = 'B';
			if (root.color == false)
				color = 'R';
			System.out.print(root.element +""+color+" ");
			inorder(root.right);
		}
	}
}
