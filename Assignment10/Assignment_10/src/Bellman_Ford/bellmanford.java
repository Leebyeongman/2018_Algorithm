package Bellman_Ford;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class bellmanford {
	public String printPath(int parent[], int v) {
		String str = "";
		v = parent[v];
		while (v >= 0) {
			str += " <- " + v;
			v = parent[v];
		}
		return str;
	}

	public void bellmanford(Edge[] edges, int source, int N) {
		int E = edges.length;
		int distance[] = new int[N];
		int parent[] = new int[N];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0;

		Arrays.fill(parent, -1);

		int k = N;

		while (--k > 0) {
			for (int j = 0; j < E; j++) {
				int u = edges[j].v;
				int v = edges[j].w;
				int w = edges[j].weight;

				if (distance[u] != Integer.MAX_VALUE && (distance[u] + w < distance[v])) {
					distance[v] = distance[u] + w;
					parent[v] = u;
				}
			}
		}

		for (int i = 0; i < E; i++) {
			int u = edges[i].v;
			int v = edges[i].w;
			int w = edges[i].weight;

			if (distance[u] != Integer.MAX_VALUE && (distance[u] + w < distance[v])) {
				System.out.println("Negative Weight Cycle Found!!");
				return;
			}
		}

		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + "Output_Bellman_Ford.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);
			String str = "";
			
			for (int i = 0; i < N; i++) {
				str = printPath(parent, i);
				System.out.println(i+ str + " " + distance[i]);
				bufWriter.write(str + distance[i]);
				bufWriter.newLine();
			}
			

			bufWriter.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}