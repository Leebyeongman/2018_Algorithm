package Kruskal;

import java.io.*;
import java.util.*;

public class kruskal {
	private int parent[]; // weightedUnion과 collapsingFind를 위한 배열
	private int size; // 정점의 수
	private int minCost = 0; // 최소 비용
	private Edge[] edges;

	public kruskal() {
		try {
			String path = main.class.getResource("").getPath(); // Get a Absolute path
			File read_file = new File(path + "graph_sample_kruskal.txt");

			// Create inputStream
			FileReader filereader = new FileReader(read_file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			String[] vertex_weigth = null;

			line = bufReader.readLine();
			int total_vertex = line.charAt(1)-48;
			int edge_size = File_read.fileSize("graph_sample_kruskal.txt");
			size = total_vertex;
			parent = new int[size];
			Arrays.fill(parent, -1); // parent 배열 -1로 초기화(정점을 독립 원소로 만듬)

			// 파일에서 읽은 데이터를 바탕으로 E 초기화
			edges = new Edge[edge_size]; // edges 배열  초기화

			int i=0;
			while((line = bufReader.readLine()) != null){ // 간선과 가중치의 나열
				vertex_weigth = line.split(" "); // 간선과 가중치를 배열로 나눠준다
				edges[i] = new Edge(Integer.parseInt(vertex_weigth[0]), Integer.parseInt(vertex_weigth[1]), Integer.parseInt(vertex_weigth[2])); 
				// add함수를 호출해서 간선과 가중치 저장
				i++;
			}

			bufReader.close();
		} catch(IOException  e) {
			e.printStackTrace();
		}
	}

	/* i가 속한 집합과 j가 속한 집합을 합집합으로 만든다 */
	public void weightedUnion(int i, int j) {
		int I_root = collapsingFind(i);// i와 j의 루트를 찾는다. collapsingFind 사용
		int J_root = collapsingFind(j);

		if(parent[I_root] >= parent[J_root]) { // i의 루트크기가 더 작으면 
			parent[J_root] = parent[I_root] + parent[J_root]; //j의 루트에 j루트의 크기 + i루트의 크기를 더한 값을 넣어준다.
			parent[I_root] = j; // j의 값을 i루트에 연결
		}
		if(parent[I_root] < parent[J_root]) { // j의 루트크기가 더 작으면
			parent[I_root] = parent[I_root] + parent[J_root]; //i의 루트에 j루트의 크기 + i루트의 크기를 더한 값을 넣어준다.			
			parent[J_root] = i; // i의 값을  j루트에 연결
		}
	}

	/* i가 속한 집합의 root를 찾는다 */
	public int collapsingFind(int i) {
		int root; // 루트 변수 선언
		for(root = i; parent[root] >= 0; root = parent[root]); // 루트를 찾는다.
		for(int j = i; j != root; j = parent[j]) {
			parent[j] = root; // parent 배열에 root값 저장 
		}
		return root;
	}

	/* Kruskal 알고리즘 구현 */
	public void Kruskal() {
		ArrayList<Edge> A = new ArrayList<Edge>();
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge a, Edge b) {
				return a.weight - b.weight;
			}
		});

		for(int i = 0; i<edges.length; i++) {
			int I_Root = collapsingFind(edges[i].v); // 루트를 찾는다
			int J_Root = collapsingFind(edges[i].w); // 루트를 찾는다
			if(I_Root == J_Root && !edges[i].selected) {  // 루트가 같으고 선택되었다면
				continue;
			} else {
				weightedUnion(edges[i].v, edges[i].w);
				edges[i].selected = true; // 선택되었다고 마킹
				minCost = minCost + edges[i].weight; // 최소비용 업데이트
				A.add(edges[i]);
			}
		}

		Kruskal_print("Output_Kruskal.txt", A);
	}

	public void Kruskal_print(String path, ArrayList<Edge> A) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);

			for (int i=0; i<A.size(); i++) {
				System.out.println(A.get(i).v + " " + A.get(i).w  + " " + A.get(i).weight);
				bufWriter.write(A.get(i).v + " " + A.get(i).w  + " " + A.get(i).weight);
				bufWriter.newLine();
			}

			bufWriter.close();
		} catch(Exception e) {
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
