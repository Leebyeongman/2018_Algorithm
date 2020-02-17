package File_management;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import LCS.main;

public class File_write {
	public static void fileSave(String path, String str) {
		try {
			String savePath = main.class.getResource("").getPath(); // Get a Absolute path
			File file = new File(savePath + path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bufWriter = new BufferedWriter(fw);
			
			bufWriter.write(str);

			bufWriter.close();
			System.out.println(path + " saved");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
