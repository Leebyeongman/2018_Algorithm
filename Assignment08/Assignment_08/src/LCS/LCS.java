package LCS;

public class LCS {
	/*
	 * direct 0 : 대각선 
	 * direct 1 : 위쪽
	 * direct 2 : 직진
	 * */
	int data;
	int direct;
	
	public LCS() {}

	public LCS(int data, int direct) {
		this.data = data;
		this.direct = direct;
	}
}
