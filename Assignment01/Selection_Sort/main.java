package Selection_Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import LinkedList.DoublyLinkedList;

public class main {
	public static void main(String[] args) {
		DoublyLinkedList select_list = new DoublyLinkedList();
		Selection_Sort selection_sort = new Selection_Sort();
		
		try {
			// ���� ��ü ����
			File read_file = new File("C:\\Users\\ssey0\\OneDrive\\���� ȭ��\\3�г� 2�б�\\�˰���\\[Al]01_201402391_�̺���\\Selection_Sort\\test_100.txt");
			// �Է� ��Ʈ�� ����
			FileReader filereader = new FileReader(read_file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			int line_num = 1;
			
			line = bufReader.readLine();
			select_list.addFirst(Integer.parseInt(line));
			
			while((line = bufReader.readLine()) != null) {
				select_list.add(line_num, Integer.parseInt(line));
				line_num++;
			}
			
			bufReader.close();

			long start = System.currentTimeMillis(); //�����ϴ� ���� ���
			 
			selection_sort.Selection(select_list);
			 
			long end = System.currentTimeMillis(); //���α׷��� ������ ���� ���
				
			
			File writer_file = new File("C:\\Users\\ssey0\\OneDrive\\���� ȭ��\\3�г� 2�б�\\�˰���\\[Al]01_201402391_�̺���\\Selection_Sort\\result_100.txt");
			FileWriter filewriter = new FileWriter(writer_file);
			BufferedWriter bufWriter = new BufferedWriter(filewriter);
			
			for(int i=0; i < select_list.size(); i++) {
				bufWriter.write(String.valueOf(select_list.get(i)));
				bufWriter.newLine();
			}
			bufWriter.write("���� �ð� : " + ( end - start )/1000.0 + "��");
			bufWriter.close();
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
