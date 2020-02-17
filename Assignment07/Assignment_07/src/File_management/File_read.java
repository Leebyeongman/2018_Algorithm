package File_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import LinkedList.LinkedList;
import Set.main;

public class File_read {
	public static LinkedList fileRead(String filename) throws IOException {
		String path = main.class.getResource("").getPath(); // Get a Absolute path
		File read_file = new File(path + filename);
		LinkedList list = new LinkedList();
		// Create inputStream
		FileReader filereader = new FileReader(read_file);
		BufferedReader bufReader = new BufferedReader(filereader);
		String line = "";
		String[] a;
		
		line = bufReader.readLine();
		a = line.split("\t");
		list.addFirst((String)a[0], Integer.parseInt(a[1]));
		while((line = bufReader.readLine()) != null) {
			a = line.split("\t");
			list.addLast((String)a[0], Integer.parseInt(a[1]));
		}
		
		bufReader.close();
		return list;
	}
}
