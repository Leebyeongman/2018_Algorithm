package BFS;

public class Graph {
	private static final Graph NIL = null;
	private String color;
	private int distance;
	private Graph pie = NIL;
	private int index;
	
	public Graph() {}
	
	public Graph(String color, int distance, Graph pie, int index) {
		this.color = color;
		this.distance = distance;
		this.pie = NIL;
		this.index = index;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Graph getPie() {
		return pie;
	}

	public void setPie(Graph pie) {
		this.pie = pie;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
