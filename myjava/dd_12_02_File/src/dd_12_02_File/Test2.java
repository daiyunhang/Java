package dd_12_02_File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws IOException {
		/*
		 * �½�d:\abc Ŀ¼
		 * �½�d:\abc\f1 �ļ�
		 * ɾ�� f1 �ļ�
		 * ɾ�� abc Ŀ¼
		 */
		
		System.out.println("���س�");
		new Scanner(System.in).nextLine();
		File dir = new File("d:/abc");
		dir.mkdirs();
		
		//
		new Scanner(System.in).nextLine();
		File file = new File("d:/abc/f1");
		file.createNewFile();
		
		
		//ɾ��
		System.out.println("���س�");
		new Scanner(System.in).nextLine();
		file.delete();
		
		
	}
}
