package Prim;
public class Graph {
	private static final Graph NIL = null;
	private Graph pie = NIL;
	private int key;
	private int index;
	
	public Graph() {}
	
	public Graph(int key) {
		this.setkey(key);
	}
	
	public Graph(Graph pie, int key, int index) {
		this.setPie(NIL);
		this.setkey(key);
		this.setIndex(index);
	}

	public Graph getPie() {
		return pie;
	}

	public void setPie(Graph pie) {
		this.pie = pie;
	}

	public int getkey() {
		return key;
	}

	public void setkey(int key) {
		this.key = key;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
