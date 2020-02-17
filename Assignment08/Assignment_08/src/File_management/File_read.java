package File_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import LCS.main;

public class File_read {
	public static ArrayList<String> fileRead(String filename) throws IOException {
		String path = main.class.getResource("").getPath(); // Get a Absolute path
		File read_file = new File(path + filename);
		// Create inputStream
		FileReader filereader = new FileReader(read_file);
		BufferedReader bufReader = new BufferedReader(filereader);
		String line = "";
		String[] a = null;
		ArrayList<String> arr = new ArrayList<String>();
		
		while ((line = bufReader.readLine()) != null) {
			a = line.split("\n");
			if (!isInteger(a[0])) 
				arr.add(a[0]);
		}
		bufReader.close();
		return arr;
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}
