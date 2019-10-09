package dd_12_02_File;

import java.io.File;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		System.out.println("�����ļ��У�");
		String s = new Scanner(System.in).nextLine();
		File dir = new File(s);
		if(! dir.isDirectory()) {
			System.out.println("�����ļ���");
			return;
		}
		long size = dirLength(dir);
		System.out.println(size);
	
	
	}

	private static long dirLength(File dir) {
		/*
		 * [dir]
		 *  |-a
		 *  |-b
		 *  |-c
		 *  	|-...
		 *  *) ��dirĿ¼�б�
		 *  *) ���б��ļ����ļ��д��������һ��
		 *  *) �ļ��д�С���õݹ���û�ȡ
		 * */
		//�б�
		File[] files = dir.listFiles();
		if(files == null) {
			return 0;
		}
		
		//�ۼӱ���
		long sum = 0;
		
		//�������ļ������ļ���
		for(File f: files) {
			if(f.isFile()) {//f���ļ�
				sum += f.length();
			}else {//f���ļ���
				sum += dirLength(f);//�ݹ������ļ��д�С
			}
		}
		
		return sum;
	}
}
