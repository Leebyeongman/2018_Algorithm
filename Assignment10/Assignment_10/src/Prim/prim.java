package Prim;

import java.io.*;
import java.util.*;

public class prim {
	private static final Graph NIL = null;
	int[][] graph;
	Graph u;
	Graph v;
	
	public prim() {}

	public void prim(int[][] graph) {
		this.graph = graph;
	}
	
	public void MST_Prim(Graph[] g, int s_vertex) {
		/* initialize */
		for (int i=0; i<g.length; i++) {
			g[i] = new Graph(NIL, Integer.MAX_VALUE, i);
		}
		g[s_vertex] = new Graph(0);
		
		/* create Queue*/
		ArrayList<Graph> que = new ArrayList<Graph>();
		for (int i=0; i<g.length; i++) {
			que.add(g[i]);
		}
		
		while (!que.isEmpty()) {
			u = minHeap.remove(minHeap.heapSort(que));
			
			for (int i=0; i<g.length; i++) {
				if (graph[u.getIndex()][i] != 0) {
					v = g[i];
					if (que.contains(v) && graph[u.getIndex()][v.getIndex()] < v.getkey()) {
						v.setPie(u);
						v.setkey(graph[u.getIndex()][v.getIndex()]);
					}
				}
			}
		}
		/* save file */
		Prim_print("Output_Prim.txt", g);
	}
	
	public void Prim_print(String path, Graph[] g) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);

			for (int i=0; i<g.length; i++) {
				if(g[i].getPie()== null) {
					System.out.println(i+" "+i+" "+g[i].getkey());
					continue;
				}
				System.out.println(i+" "+g[i].getPie().getIndex()+" "+g[i].getkey());
				bufWriter.write(i+" "+g[i].getPie().getIndex()+" "+g[i].getkey());
				bufWriter.newLine();
			}

			bufWriter.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
