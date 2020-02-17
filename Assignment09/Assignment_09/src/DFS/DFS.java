package DFS;

import java.io.*;

public class DFS {
	private static final Graph NIL = null;
	private Graph u;
	private Graph v;
	int time;;
	
	public DFS() {}

	public DFS(int[][] arr, Graph[] g) {
		for (int i=0; i<arr.length; i++) {
			g[i] = new Graph("WHITE", 0, NIL, 0, i+1); 
		}

		time = 0;
		for (int i=0; i<arr.length; i++) {
			u = g[i];
			if (u.getColor() == "WHITE") {
				DFS_visit(g, u, arr);
			}
		}
		DFS_print("Output_DFS.txt",g);
	}

	public void DFS_visit(Graph[] g, Graph u, int[][] arr) {
		time = time + 1;
		u.setDepart_time(time);
		u.setColor("GRAY");
		for (int i=0; i<arr.length; i++) {
			if (arr[u.getIndex()-1][i] == 1) {
				v = g[i];
				if (v.getColor() == "WHITE") {
					v.setPie(u);
					DFS_visit(g, v, arr);
				}
			}
		}
		u.setColor("BLACK");
		time++;
		u.setFinal_time(time);
	}

	public void DFS_print(String path, Graph[] g) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);

			for(int i=0; i<g.length; i++) {
				bufWriter.write(g[i].getIndex()+" "+g[i].getDepart_time() + " " + g[i].getFinal_time());
				System.out.println(g[i].getIndex()+" "+g[i].getDepart_time() + " " + g[i].getFinal_time());
				bufWriter.newLine();
			}
			
			bufWriter.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
