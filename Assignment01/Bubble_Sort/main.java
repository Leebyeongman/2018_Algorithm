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
			// ���� ��ü ����
			File read_file = new File("C:\\Users\\ssey0\\OneDrive\\���� ȭ��\\3�г� 2�б�\\�˰���\\[Al]01_201402391_�̺���\\Bubble_Sort\\test_100.txt");
			// �Է� ��Ʈ�� ����
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
			
			long start = System.currentTimeMillis(); //�����ϴ� ���� ���
			 
			bubble_sort.Bubble(bubble_list); // ����ð��� �����ϰ���� �ڵ�
			 
			long end = System.currentTimeMillis(); //���α׷��� ������ ���� ���
						
			File writer_file = new File("C:\\Users\\ssey0\\OneDrive\\���� ȭ��\\3�г� 2�б�\\�˰���\\[Al]01_201402391_�̺���\\Bubble_Sort\\result_100.txt");
			FileWriter filewriter = new FileWriter(writer_file);
			BufferedWriter bufWriter = new BufferedWriter(filewriter);
			
			for(int i=0; i < bubble_list.size(); i++) {
				bufWriter.write(String.valueOf(bubble_list.get(i)));
				bufWriter.newLine();
			}
			bufWriter.write("���� �ð� : " + ( end - start )/1000.0 + "��");
			bufWriter.close();
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
