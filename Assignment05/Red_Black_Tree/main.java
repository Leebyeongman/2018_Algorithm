package Red_Black_Tree;

import java.io.IOException;
import java.util.ArrayList;

import Binary_Tree.BST;
import File_management.*;

public class main {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> dataArray = File_read.fileRead("Data1.txt");
		RedBlackTree rbt = new RedBlackTree(Integer.MIN_VALUE);
		BST bst = new BST();
		
		System.out.println("------------ Red_Black_Tree TEST ------------");
		long start = System.nanoTime(); // Program start point
		for (int i = 0; i < dataArray.size(); i++)
			rbt.insert((int) dataArray.get(i));
		long end = System.nanoTime(); // Program end point
		System.out.println("TIME(RBT_Insert) : " + ( end - start ) / 1000000.0 + "(ms)");
		
		start = System.nanoTime(); // Program start point
		rbt.search(32);
		end = System.nanoTime(); // Program end point
		System.out.println("TIME(RBT_Search) : " + ( end - start ) / 1000000.0 + "(ms)\n");
		
		rbt.inorder();
		System.out.println();
		
		System.out.println("\n------------ Binary_Search_Tree TEST ------------");
		start = System.nanoTime(); // Program start point
		for (int i = 0; i < dataArray.size(); i++) 
			bst.insertBST((int) dataArray.get(i));
		end = System.nanoTime(); // Program end point
		System.out.println("TIME(BST_Insert) : " + ( end - start ) / 1000000.0 + "(ms)");
		
		//System.out.println("------------ Binary_Search_Tree Search ------------");
		start = System.nanoTime(); // Program start point
		bst.search(32);
		end = System.nanoTime(); // Program end point
		System.out.println("TIME(BST_Search) : " + ( end - start ) / 1000000.0 + "(ms)\n");
		
		bst.printBST(dataArray);
	}
}