package LCS;

import java.io.IOException;
import java.util.ArrayList;
import File_management.*;

public class main {
	public static void main(String[] args) throws IOException {
		ArrayList<String> arr = File_read.fileRead("LCS_Data.txt");
		LCS_function.lsc_length(arr.get(0), arr.get(1));
	}
}
