package BFS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import BFS.main;

public class File_read {
	public static int[][] fileRead(String filename) throws IOException {
		String path = main.class.getResource("").getPath(); // Get a Absolute path
		File read_file = new File(path + filename);
		// Create inputStream
		FileReader filereader = new FileReader(read_file);
		BufferedReader bufReader = new BufferedReader(filereader);
		String line = "";
		String[] store = null;

		line = bufReader.readLine();
		store = line.split("\n");
		int size = Integer.parseInt(store[0]);
		int[][] arr = new int[size][size]; // create 8 by 8 array

		int i=0;
		while ((line = bufReader.readLine()) != null) {
			 store = line.split(" ");
			 for (int j=0; j<store.length; j++) {
				arr[i][j]= Integer.parseInt(store[j]); 
			 }
			 i++;
		}
		print(size, arr);
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
	
	private static void print(int size, int[][] arr) {
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}	
		System.out.println();
	}
}
