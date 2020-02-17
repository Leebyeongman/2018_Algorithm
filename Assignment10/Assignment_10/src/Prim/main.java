package Prim;

import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException {
		int list[][] = File_read.fileRead("graph_sample_prim.txt");
		prim prim = new prim();
		Graph[] g = new Graph[list.length];
		prim.prim(list);
		prim.MST_Prim(g, 0);
	}
}
