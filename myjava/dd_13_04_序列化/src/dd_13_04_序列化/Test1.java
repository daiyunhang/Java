package dd_13_04_���л�;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
		 * Student����,���л����,���浽�ļ�
		 * 
		 *  OOS--FOS--f5
		 *  
		 */
		Student s =
		new Student(9527,"�Ʋ���","��",19);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/abc/f5"));
		//���л�ѧ������
		out.writeObject(s);
		
		out.close();
	}
	
}
