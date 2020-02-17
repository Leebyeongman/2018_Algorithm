package Dijkstra;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		int list[][] = File_read.fileRead("graph_sample_dijkstra.txt");
		dijkstra Dijkstra = new dijkstra();
		Graph[] g = new Graph[list.length];
		
		Dijkstra.dijkstra(list);
		Dijkstra.Dijkstra(g, 1);
	}
}
