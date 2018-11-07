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

		while (current.element != key) {	// �������� ���� key�� ���� ������        
			great_grand_parent = grand_parent;	// �Ҿƹ����� ������
			grand_parent = parent; 	// �θ� �Ҿƹ�����
			parent = current;		// ���縦 �θ��
			if (key < current.element)	// �������� ���� key���� ������
				current = current.left;	// �������� ��������
			else
				current = current.right;	// �������� ����������	
			if (current.left.color == Red && current.right.color == Red) // �������� ��/�������� ���� Red�̸� 
				rebalance(key); // ���ġ
		}
		if (current != NIL) // �����尡 NIL�� �ƴ϶��
			return;	// �Լ� ����
		current = new RedBlackNode(key, NIL, NIL); // ������ ��� ����
		if (key < parent.element) // �θ��� ���� key���� ũ��
			parent.left = current; // �����带 �θ��� ���ʿ�
		else	// ������
			parent.right = current;	// �����带 �θ��� �����ʿ�        
		rebalance(key); // ���ġ
	}

	private void rebalance(int key) {
		current.color = Red;
		current.left.color = Black; // ������ ��
		current.right.color = Black; // ������ ��

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
