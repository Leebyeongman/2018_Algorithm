package Insert;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import File_management.*;

public class main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String file = null;

		/* Menu */
		while(true) {
			System.out.println("Select File name...");
			System.out.println("1. Data1.txt");
			System.out.println("2. Data2.txt");
			System.out.println("3. exit");
			System.out.print("Input : ");
			int str = sc.nextInt(); // Select File name
			System.out.println();

			if (str == 1) 
				file = "Data1.txt";
			else if (str == 2)
				file = "Data2.txt";
			else {
				System.out.println("Program terminate");
				sc.close();
				System.exit(0);
			}	    		

			/* BST */
			ArrayList<Integer> dataArray1 = File_read.fileRead(file); // File Read
			ArrayList<Integer> dataArray2 = File_read.fileRead(file); // File Read
			BST bst = new BST();
			BST median_bst = new BST();

			System.out.println("------------ Basic Insert ------------");
			long start = System.nanoTime(); // Program start point
			for (int i = 0; i < dataArray1.size(); i++) 
				bst.insertBST((int) dataArray1.get(i));
			long end = System.nanoTime(); // Program end point
			System.out.println("TIME(Insert) : " + ( end - start ) / 1000000.0 + "(ms)");

			ArrayList<Integer> insertArray = new ArrayList<Integer>(dataArray1.size());
			insertArray = bst.printBST(insertArray);
			
			start = System.nanoTime(); // Program start point
			for (int i = 0; i < dataArray1.size(); i++) 
				bst.iter_search((int)dataArray1.get(i));
			end = System.nanoTime(); // Program end point
			System.out.println("TIME(Iterative Search) : " + ( end - start ) / 1000000.0 + "(ms)");

			start = System.nanoTime(); // Program start point
			for (int i = 0; i < dataArray1.size(); i++) 
				bst.recuBST((int)dataArray1.get(i));
			end = System.nanoTime(); // Program end point
			System.out.println("TIME(Recursive Search) : " + ( end - start ) / 1000000.0 + "(ms)\n");

			System.out.println("------------ Basic Insert print ------------");
			bst.printBST(dataArray1);
			System.out.println("------------ Delete 11 ------------");
			bst.delete(55);
			bst.printBST(dataArray1);
			System.out.println("------------ Delete 12 ------------");
			bst.delete(12);
			bst.printBST(dataArray1);
			System.out.println("------------ Delete 25 ------------");
			bst.delete(25);
			bst.printBST(dataArray1);

			System.out.println("------------ Array Sort ------------");
			start = System.nanoTime(); // Program start point
			Collections.sort(dataArray2);
			end = System.nanoTime(); // Program end point
			System.out.println("TIME() : " + ( end - start ) / 1000000.0 + "(ms)\n");
			
			System.out.println("------------ Median Insert ------------");
			start = System.nanoTime(); // Program start point
			median_bst.medianBST(dataArray2);
			end = System.nanoTime(); // Program end point
			System.out.println("TIME(Median Insert) : " + ( end - start ) / 1000000.0 + "(ms)");

			start = System.nanoTime(); // Program start point
			for (int i = 0; i < dataArray2.size(); i++) 
				median_bst.iter_search((int)dataArray2.get(i));
			end = System.nanoTime(); // Program end point
			System.out.println("TIME(Iterative Search) : " + ( end - start ) / 1000000.0 + "(ms)");

			start = System.nanoTime(); // Program start point
			for (int i = 0; i < dataArray2.size(); i++) 
				median_bst.recuBST((int)dataArray2.get(i));
			end = System.nanoTime(); // Program end point
			System.out.println("TIME(Recursive Search) : " + ( end - start ) / 1000000.0 + "(ms)\n");
			
			if (str==2) {
				System.out.println("------------ Median Insert print ------------");
				median_bst.printBST(dataArray2);
				median_bst.delete(11);
				System.out.println("------------ Delete 11 ------------");
				median_bst.printBST(dataArray2);
				median_bst.delete(21);
				System.out.println("------------ Delete 12 ------------");
				median_bst.printBST(dataArray2);
				median_bst.delete(36);
				System.out.println("------------ Delete 25 ------------");
				median_bst.printBST(dataArray2);
			}
			
			File_write.fileSave("result_"+ insertArray.size() + "_print.txt", insertArray); // File save
		}
	}
}
