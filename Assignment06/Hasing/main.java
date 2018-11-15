package Hasing;

import java.io.IOException;
import java.util.ArrayList;

import File_management.*;

public class main {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> dataArray1 = File_read.fileRead("Data1.txt");
		ArrayList<Integer> dataArray2 = File_read.fileRead("Data2.txt");
		ArrayList<Integer> dataArray3 = File_read.fileRead("Data3.txt");
		ArrayList<Object> outputArray = new ArrayList<Object>();
		
		LinearProbingHashTable map1 = new LinearProbingHashTable();
		QuadraticProbingHashTable map2 = new QuadraticProbingHashTable();
		DoubleHashingHashTable map3 = new DoubleHashingHashTable();
		System.out.println("------------ Hash Table TEST ------------");
		System.out.println();
		
		for (int i=0; i<dataArray1.size(); i++) {
			map1.put(dataArray1.get(i), dataArray1.get(i));
		}
		
		for (int i=0; i<dataArray2.size(); i++) {
			map1.remove(dataArray2.get(i));
		}
		
		for (int i=0; i<dataArray3.size(); i++) {
			outputArray.add(map1.get(dataArray3.get(i)));
		}
		File_write.fileSave("result_Linear.txt", outputArray);
		outputArray.clear();
		
		for (int i=0; i<dataArray1.size(); i++) {
			map2.put(dataArray1.get(i), dataArray1.get(i));
		}
		
		for (int i=0; i<dataArray2.size(); i++) {
			map2.remove(dataArray2.get(i));
		}
		
		for (int i=0; i<dataArray3.size(); i++) {
			outputArray.add(map2.get(dataArray3.get(i)));
		}
		File_write.fileSave("result_Quadratic.txt", outputArray);
		outputArray.clear();
		
		for (int i=0; i<dataArray1.size(); i++) {
			map3.put(dataArray1.get(i), dataArray1.get(i));
		}
		
		for (int i=0; i<dataArray2.size(); i++) {
			map3.remove(dataArray2.get(i));
		}
		
		for (int i=0; i<dataArray3.size(); i++) {
			outputArray.add(map3.get(dataArray3.get(i)));
		}
		File_write.fileSave("result_Double.txt", outputArray);
		outputArray.clear();

		System.out.println("***** Collision Count *****");
		System.out.println("LineProb: " + map1.collusionCount());
		System.out.println("QuadProd: " + map2.collusionCount());
	    System.out.println("DoubHash: "+ map3.collusionCount());
		System.out.println();
	}
}
