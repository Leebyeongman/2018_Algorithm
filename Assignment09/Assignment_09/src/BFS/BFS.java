package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private static final Graph NIL = null;
	private Graph u;
	private Graph v;

	public BFS() {}

	public BFS(int[][] arr, int s_vertex, Graph[] g) {
		for (int i=0; i<arr.length; i++) {
			if (i != s_vertex-1) 
				g[i] = new Graph("WHITE", Integer.MAX_VALUE, NIL, i+1); 
		}
		
		g[s_vertex-1] = new Graph("GRAY", 0, NIL, s_vertex);
		Queue<Graph> que = new LinkedList<Graph>();
		que.add(g[s_vertex-1]);

		while (!que.isEmpty()) {
			u = que.poll();
			for (int i=0; i<arr.length; i++) {
				if (arr[u.getIndex()-1][i] == 1) {
					v = g[i];
					if (v.getColor() == "WHITE") {
						v.setColor("GRAY");
						v.setDistance(u.getDistance() + 1);
						v.setPie(u);
						que.add(v);
					}
				}
			}
			u.setColor("BLACK");
		}
		BFS_print("Output_BFS.txt", g);
	}

	public void BFS_print(String path, Graph[] g) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);

			for(int i=0; i<g.length; i++) {
				bufWriter.write(g[i].getIndex()+" "+g[i].getDistance());
				System.out.println(g[i].getIndex()+" "+g[i].getDistance());
				bufWriter.newLine();
			}

			bufWriter.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
