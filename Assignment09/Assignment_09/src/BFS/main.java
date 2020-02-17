package BFS;

import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int arr[][] = File_read.fileRead("graph.txt");
		System.out.print("시작 정점 선택 : ");
		int start = sc.nextInt();
		
		Graph[] g = new Graph[arr.length];
		new BFS(arr, start, g);
		sc.close();
	}
}
