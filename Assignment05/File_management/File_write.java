package File_management;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import Red_Black_Tree.main;

public class File_write {
	public static void fileSave(String path, ArrayList<Integer> dataArray1) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);

			for(int i = 0; i < dataArray1.size(); i++) {
				bufWriter.write(String.valueOf(dataArray1.get(i)));
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
