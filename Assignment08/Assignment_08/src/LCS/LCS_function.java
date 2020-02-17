package LCS;

import File_management.File_write;
import LCS.LCS;
public class LCS_function {
	public static void lsc_length(String X, String Y) {
		/* variable */
		int m = X.length();
		int n = Y.length();
		String X_arr[] = new String[m+1];
		String Y_arr[] = new String[n+1];
		LCS c[][] = new LCS[m+1][n+1];

		/* create array */
		for (int i=0; i<X_arr.length-1; i++) 
			X_arr[i+1] = X.substring(i, i+1);
		for (int i=0; i<Y_arr.length-1; i++) 
			Y_arr[i+1] = Y.substring(i, i+1);

		/* c array setting */
		for (int i=1; i<=m; i++) 
			c[i][0] = new LCS();
		for (int j=1; j<=n; j++) 
			c[0][j] = new LCS();

		/* string check */
		for (int i=1; i<=m; i++) {
			for (int j=1; j<=n; j++) {
				if (X_arr[i].equals(Y_arr[j]))
					c[i][j] = new LCS(c[i-1][j-1].data + 1, 0);
				else if (c[i-1][j].data >= c[i][j-1].data)
					c[i][j] = new LCS(c[i-1][j].data, 1);
				else
					c[i][j] = new LCS(c[i][j-1].data, 2);
			}
		}
		for (int i=1; i<=m; i++) {
			System.out.println();
			for (int j=1; j<=n; j++)
				System.out.print("["+c[i][j].data +","+ c[i][j].direct +"] ");
		}
		System.out.println();
		File_write.fileSave("Output.txt", print_lcs(c, X_arr, m, n));
		str = ""; // 초기화
	}
	
	static String str = "";
	public static String print_lcs(LCS[][] b, String[] X_arr, int i, int j) {
		if (i == 0 || j == 0)
				return str;
		if (b[i][j].direct == 0) {
			print_lcs(b, X_arr, i-1, j-1);
			return str += X_arr[i];
		}
		else if (b[i][j].direct == 1) {
			print_lcs(b, X_arr, i-1, j);
		}
		else {
			print_lcs(b, X_arr, i, j-1);
		}
		return str; 
	}
}
