package Insert;

import java.util.ArrayList;

public class BST {
	public Node root;

	public BST() {
		this.root = null;
	}

	public void insertBST(int key) {
		root = insert(root, key);
	}

	public Node insert(Node root, int key) {
		Node p = root;
		Node newNode = new Node(key);

		if (p == null)
			return newNode;
		else if (p.data > newNode.data) {
			p.left = insert(p.left, key);
			return p;
		}
		else if (p.data < newNode.data) {
			p.right = insert(p.right, key);
			return p;
		}
		else 
			return p;
	}

	public boolean iter_search(int key) { // 탐색 메소드: 트리 내에 탐색하려는 key값이 있다면 true, 없다면 false를 return
		Node current = root;
		while(current!=null) {
			if (current.data == key) //현재 노드와 찾는 값이 같으면
				return true;
			else if(current.data > key) //찾는 값이 현재 노드보다 작으면
				current = current.left;
			else //찾는 값이 현재 노드보다 크면
				current = current.right;
		}
		return false;
	}

	public void recuBST(int key) {
		root = recu_search(root, key);
	}

	public Node recu_search(Node root, int key) {
		Node current = root;
		if (current.data == key)
			return current;
		else if (current.data > key) {
			current.left = recu_search(current.left, key);
			return current;
		}
		else if (current.data < key) {
			current.right = recu_search(current.right, key);
			return current;
		}
		else
			return null;
	}

	public void medianBST(ArrayList<Integer> list) {
		root = median_insert(list, 0, list.size() - 1);
	}

	public Node median_insert(ArrayList<Integer> list, int start, int end) {
		if (start > end ) 
			return null;
		int median_value = (start + end) / 2;
		Node node = new Node(list.get(median_value));
		node.left = median_insert(list, start, median_value - 1);
		node.right = median_insert(list, median_value + 1, end);
		return node;
	}

	public ArrayList<Integer> inorder(Node root, ArrayList<Integer> list){
		if(root!=null){
			inorder(root.left, list);
			System.out.print(root.data + " ");
			list.add(root.data);
			inorder(root.right, list);
		}
		return list;
	}

	public ArrayList<Integer> printBST(ArrayList<Integer> list) {
		inorder(root, list);
		System.out.println();
		System.out.println();
		return list;
	}
	
	public boolean delete(int key){
		Node parent = root;
		Node current = root;
		boolean isRightchild = false;
		if (!iter_search(key)) {
			System.out.println("Value is not exist.");
			return false;
		}
		while (current.data != key) {
			parent = current;
			if (current.data > key) {
				current = current.left;
				isRightchild = false;
			}
			else if (current.data < key){
				current = current.right;
				isRightchild = true;
			}
			else
				return false;
		}
		if (current.left == null & current.right == null) {
			if (current == root)
				root = null;
			if (isRightchild)
				parent.right = null;
			else
				parent.left = null;
		}
		else if (current.left == null) {
			if (current == root)
				root = current.right;
			else if (isRightchild)
				parent.right = current.right;
			else
				parent.left = current.right;
		}
		else if (current.right == null) {
			if (current == root)
				root = current.left;
			else if (isRightchild)
				parent.right = current.left;
			else
				parent.left = current.left;
		}
		else if (current.left != null && current.right != null) {
			Node successor = successor(current); 
			if (current == root) 
				root = successor; 
			else if (isRightchild) 
				parent.right = successor; 
			else 
				parent.left = successor;
			successor.left = current.left;
		}
		return true;
	}

	public Node successor(Node data) {
		Node successsor = null; 
		Node successsorParent = null; 
		Node current = data.right; 
		
		while (current != null) {  
			successsorParent = successsor; 
			successsor = current;
			current = current.left; 
		} 
		if (successsor != data.right) { 
			successsorParent.left = successsor.right; 
			successsor.right = data.right; 
		} 
		return successsor;
	}
	
	public Node predecessor(Node data) {
		Node predecessor = null;
		Node predecessorParent = null;
		Node current = data.left;
		
		while (current != null) {
			predecessorParent = predecessor;
			predecessor = current;
			current = current.right;
		}
		if (predecessor != data.left) {
			predecessorParent.right = predecessor.left;
			predecessor.left = data.left;
		}
		return predecessor;
	}
}

