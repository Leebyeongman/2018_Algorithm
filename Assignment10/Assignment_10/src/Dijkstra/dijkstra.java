package Dijkstra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class dijkstra {
	private static final Graph NIL = null;
	int[][] graph;
	Graph u;
	Graph v;
	int w;
	
	public dijkstra() {}

	public void dijkstra(int[][] graph) {
		this.graph = graph;
	}
	
	public void Dijkstra(Graph[] g, int s_vertex) {
		ArrayList<Graph> S = new ArrayList<Graph>();
		
		/* initialize */
		for (int i=0; i<g.length; i++) {
			g[i] = new Graph(NIL, Integer.MAX_VALUE, i);
		}
		g[s_vertex] = new Graph(0, s_vertex);
		
		/* create Queue*/
		ArrayList<Graph> que = new ArrayList<Graph>();
		for (int i=0; i<g.length; i++) {
			que.add(g[i]);
		}
		
		while (!que.isEmpty()) {
			u = minHeap.remove(minHeap.heapSort(que));
			S.add(u);
			
			for (int i=0; i<g.length; i++) {
				if (graph[u.getIndex()][i] != 0) {
					v = g[i];
					relax(u, v, graph[u.getIndex()][i]);
					
				}
			}
		}
		/* save file */
		Dijkstar_print("Output_Dijkstar.txt", g);
	}
	
	public void relax(Graph u, Graph v, int w) {
		if (v.getDistance() > u.getDistance() + w) {
			v.setDistance(u.getDistance() + w);
			v.setPie(u);
		}
	}
	
	public void Dijkstar_print(String path, Graph[] g) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);
			String str = "";
			int j=0;
			for (int i=0; i<g.length; i++) {
				j=i;
				while (g[j].getPie() != null) {
					str += "<-" + g[j].getPie().getIndex();
					j = g[j].getPie().getIndex();
				}
				System.out.println(i + str + " " + g[i].getDistance());
				bufWriter.write(i + str + " " + g[i].getDistance());
				bufWriter.newLine();
				str = "";
			}

			bufWriter.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
