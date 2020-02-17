package Dijkstra;

public class Graph {
	private static final Graph NIL = null;
	private Graph pie = NIL;
	private int distance;
	private int index;
	
	public Graph() {}
	
	public Graph(int distance, int index) {
		this.setDistance(distance);
		this.setIndex(index);
	}
	
	public Graph(Graph pie, int distance, int index) {
		this.setPie(NIL);
		this.setDistance(distance);
		this.setIndex(index);
	}

	public Graph getPie() {
		return pie;
	}

	public void setPie(Graph pie) {
		this.pie = pie;
	}

	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
