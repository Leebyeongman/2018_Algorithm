package DFS;

import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int arr[][] = File_read.fileRead("graph.txt");
		Graph[] g = new Graph[arr.length];
		new DFS(arr, g);
		sc.close();
	}
}
