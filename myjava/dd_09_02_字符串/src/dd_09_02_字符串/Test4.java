package dd_09_02_�ַ���;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		System.out.print("������ģ�");
		String s = new Scanner(System.in).nextLine();
		if(huiWen(s)) {
			System.out.println("�ǻ���");
		}else {
			System.out.println("���ǻ���");
		}
	}

	private static boolean huiWen(String s) {
		/*
		 * asddsa
		 * i    j
		 * 
		 * 1.forѭ��i=0,n=ĩβ; ������i<j
		 * 		2.���iλ���ַ���jλ���ַ������
		 * 			3.����false
		 * 4.����true 
		 */
		for(int i=0,j=s.length()-1; i<j; i++,j--) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			
		}
		return true;
	
	}
}
