package Bellman_Ford;

import java.io.*;
import java.util.*;

public class bellman_ford {
	private Edge[] edges;
	
	public bellman_ford() {
		try {
			String path = main.class.getResource("").getPath(); // Get a Absolute path
			File read_file = new File(path + "graph_sample_bellman.txt");

			// Create inputStream
			FileReader filereader = new FileReader(read_file);
			BufferedReader bufReader = new BufferedReader(filereader);
			
			int counter = File_read.fileSize("graph_sample_bellman.txt");
			String line = "";
			String[] vertex_weigth = null;
			
			line = bufReader.readLine();
			int total_vertex = Integer.parseInt(line);
			
			int i=0;
			edges = new Edge[counter];
			while ((line = bufReader.readLine()) != null) {
				vertex_weigth = line.split(" ");
				edges[i] = new Edge(Integer.parseInt(vertex_weigth[0]), Integer.parseInt(vertex_weigth[1]), Integer.parseInt(vertex_weigth[2]));
				i++;
			}
			
			final int N = total_vertex;
			
			bellmanford bellmanfords = new bellmanford();
			bellmanfords.bellmanford(edges, 1, N);
			bufReader.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
class Edge {
	int v, w; // 정점
	int weight; // 가중치
	boolean selected; // 선택된 정점을 마킹하는 변수

	public Edge(int v, int w, int weight) { // E를 초기화 해주는 생성자	
		this.v = v;
		this.w = w;
		this.weight = weight;
		selected = false;
	}
}
