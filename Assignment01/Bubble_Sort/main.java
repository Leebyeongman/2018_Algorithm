package Bubble_Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import LinkedList.DoublyLinkedList;

public class main {
	public static void main(String[] args) {
		DoublyLinkedList bubble_list = new DoublyLinkedList();
		Bubble_Sort bubble_sort = new Bubble_Sort();
		
		try {
			// 파일 객체 생성
			File read_file = new File("C:\\Users\\ssey0\\OneDrive\\바탕 화면\\3학년 2학기\\알고리즘\\[Al]01_201402391_이병만\\Bubble_Sort\\test_100.txt");
			// 입력 스트링 생성
			FileReader filereader = new FileReader(read_file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			int line_num = 1;
			
			line = bufReader.readLine();
			bubble_list.addFirst(Integer.parseInt(line));
			
			while((line = bufReader.readLine()) != null) {
				bubble_list.add(line_num, Integer.parseInt(line));
				line_num++;
			}
			
			bufReader.close();
			
			long start = System.currentTimeMillis(); //시작하는 시점 계산
			 
			bubble_sort.Bubble(bubble_list); // 실행시간을 측정하고싶은 코드
			 
			long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
						
			File writer_file = new File("C:\\Users\\ssey0\\OneDrive\\바탕 화면\\3학년 2학기\\알고리즘\\[Al]01_201402391_이병만\\Bubble_Sort\\result_100.txt");
			FileWriter filewriter = new FileWriter(writer_file);
			BufferedWriter bufWriter = new BufferedWriter(filewriter);
			
			for(int i=0; i < bubble_list.size(); i++) {
				bufWriter.write(String.valueOf(bubble_list.get(i)));
				bufWriter.newLine();
			}
			bufWriter.write("실행 시간 : " + ( end - start )/1000.0 + "초");
			bufWriter.close();
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
