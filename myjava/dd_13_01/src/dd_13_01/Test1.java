package dd_13_01;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("�����ļ�:");
		String s = new Scanner(System.in).nextLine();
		File file = new File(s);
		if(!file.isFile()) {
			System.out.println("�����ļ�");
			return;
		}
		System.out.println("KEY:");
		int key = new Scanner(System.in).nextInt();
		try {
			encrpt(file, key);
			System.out.println("���");
		} catch (Exception e) {
			System.out.println("ʧ��");
			e.printStackTrace();
		}
	}

	private static void encrpt(File file, int key) throws Exception {
		/*
		 * ���ļ���ȡһ���ֽ�ֵ
		 * ��key����,��д�ص��ļ�
		 */
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		//���ֽڷ����׼ģʽ
//		int b;
//		while((b = raf.read()) != -1) {
//			b ^= key;//������or����
//			raf.seek(raf.getFilePointer()-1);//�±�����Ųһλ
//			raf.write(b);//�ֽ�ֵд�ص��ļ�
//		}
		
//		-------------------------------------------------------------------
		//������д byteһ����8k 8192
		byte[] buff = new byte[8192];
		int n;//����һ��������
		while((n = raf.read()) != -1) {
			//������ǰn���ֽ�ֵ����
			for(int i=0;i<n;i++) {
				buff[i] ^= key;
			}
			//�±�ǰ��n��λ��
			raf.seek(raf.getFilePointer()-n);
			//������ǰn���ֽ�,һ��д���ļ�
			raf.write(buff,0,n);
		}
		
		
		
		
		
		
		
		raf.close();
		
	}
}
