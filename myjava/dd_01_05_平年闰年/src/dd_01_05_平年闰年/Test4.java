package dd_01_05_ƽ������;

import java.util.Scanner;

public class Test4 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.print("������ţ� ");
		int y = new Scanner(System.in).nextInt();
		
		/**
		 * �����y���ݵ�runNian()������������
		 * ���жϸ÷����ķ���ֵ�����Ǽ�
		 * */
		boolean b = runNian(y);
		
		if(b) {
			System.out.println("����");
		}else {
			System.out.println("ƽ��");
		}
		
		
		System.out.println(y);
		
	}
	
	static boolean runNian(int y) {
		//y�ܱ�4����
		if(y%4 == 0) {
			//�ܱ�4����������£����жϲ��ܱ�100����
			if(y%100 != 0) {
				return true;
			}
		}
		//y�ܱ�400����
		if(y%400 == 0) {
			return true;
		}
		
		return false;
	}
	
	
	
	
}
