package Min_Heap_Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String file = null;
		int arrLength = 0;

		/* Menu */
		while(true) {
			System.out.println("Select File name...");
			System.out.println("1. test_100.txt");
			System.out.println("2. test_1000.txt");
			System.out.println("3. exit");
			System.out.print("Input : ");
			int str = sc.nextInt(); // Select File name
			System.out.println();

			if (str == 1) {
				file = "test_100.txt";
				arrLength = 100;
			}
			else if (str == 2){
				file = "test_1000.txt";
				arrLength = 1000;
			}
			else {
				System.out.println("Program terminate");
				sc.close();
				System.exit(0);
			}	    		

			/* Min_Heap sort*/
			int[] dataArray1 = fileRead(file, arrLength); // File Read
			long start1 = System.nanoTime(); // Program start point 
			dataArray1 = minHeap.heapSort(dataArray1);
			long end1 = System.nanoTime(); // Program end point
			System.out.println("TIME(minHeap): " + ( end1 - start1 )/1000000.0 + "(ms)");

			fileSave("result_"+ arrLength + "_heap.txt", dataArray1); // File save 
		}
	}

	public static int[] fileRead(String filename, int arrLength) throws IOException {
		String path = main.class.getResource("").getPath(); // Get a Absolute path
		File read_file = new File(path + filename);

		// Create inputStream
		FileReader filereader = new FileReader(read_file);
		BufferedReader bufReader = new BufferedReader(filereader);
		String line = "";
		int[] intArray = new int[arrLength];
		int i = 0;

		while((line = bufReader.readLine()) != null) {
			intArray[i] = Integer.parseInt(line);
			i++;
		}

		bufReader.close();
		System.out.println("Hey!! File read finish...");

		return intArray;
	}

	public static void fileSave(String path, int[] resultArray) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);

			for(int i=0; i<resultArray.length; i++) {
				bufWriter.write(String.valueOf(resultArray[i]));
				bufWriter.newLine();
			}

			bufWriter.close();
			System.out.println("Hey!! File save finish...");
			System.out.println();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
