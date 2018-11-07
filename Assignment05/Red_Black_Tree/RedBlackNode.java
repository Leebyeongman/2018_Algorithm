package Red_Black_Tree;

public class RedBlackNode {    
	RedBlackNode left, right;
	int element;
	boolean color;

	public RedBlackNode(int theElement) {
		this(theElement, null, null);
	} 

	public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt) {
		left = lt;
		right = rt;
		element = theElement;
		color = true;
	}
}
