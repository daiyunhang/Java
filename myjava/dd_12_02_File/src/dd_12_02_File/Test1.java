package dd_12_02_File;

import java.io.File;

public class Test1 {
	public static void main(String[] args) {
		String path;
		
//		path = "D:\\ecl.exe";//���ڵ��ļ�
//		path = "D:\\a";//���ڵ��ļ���
		path = "x:\\ff\\aa\\bb";//�����ڵ�·��
		
		File file = new File(path);
		System.out.println(file.exists());//�Ƿ����
		System.out.println(file.length());//�ֽ������ļ�����Ч
		System.out.println(file.isFile());//�Ƿ����ļ�
		System.out.println(file.isDirectory());//�Ƿ����ļ���
		
	}
}
