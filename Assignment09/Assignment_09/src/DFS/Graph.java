package DFS;

public class Graph {
	private static final Graph NIL = null;
	private String color;
	private int depart_time;
	private Graph pie = NIL;
	private int final_time;
	private int index;
	
	public Graph() {}
	
	public Graph(String color, int depart_time, Graph pie, int final_time, int index) {
		this.color = color;
		this.depart_time = depart_time;
		this.pie = NIL;
		this.final_time = final_time;
		this.index = index;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDepart_time() {
		return depart_time;
	}

	public void setDepart_time(int depart_time) {
		this.depart_time = depart_time;
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

	public int getFinal_time() {
		return final_time;
	}

	public void setFinal_time(int final_time) {
		this.final_time = final_time;
	}
}
