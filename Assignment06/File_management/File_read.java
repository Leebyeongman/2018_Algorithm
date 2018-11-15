package File_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Hasing.main;

public class File_read {
	public static ArrayList<Integer> fileRead(String filename) throws IOException {
		String path = main.class.getResource("").getPath(); // Get a Absolute path
		File read_file = new File(path + filename);

		// Create inputStream
		FileReader filereader = new FileReader(read_file);
		BufferedReader bufReader = new BufferedReader(filereader);
		String line = "";
		ArrayList<Integer> intArray = new ArrayList<Integer>();

		while((line = bufReader.readLine()) != null)
			intArray.add(Integer.parseInt(line));
		
		bufReader.close();
		return intArray;
	}
}
