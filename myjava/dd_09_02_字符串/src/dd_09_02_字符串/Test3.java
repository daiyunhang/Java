package dd_09_02_�ַ���;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.print("����email��");
		String e = new Scanner(System.in).nextLine();
		String n = getName(e);
		System.out.println(n);
	}

	private static String getName(String e) {
		/*
		 * asdf@asdasd.com
		 * |   | 
		 * 0   4
		 * 
		 * 1.��"@"��λ�ô�ŵ�index
		 * 2.���index==-1,������"��ʽ����"
		 * 3.��ȡ[0,index),������
		 */
		e = e.trim();
		int index = e.indexOf("@"); 
		if(index == -1) {
			return "��ʽ����";
		}
		return e.substring(0,index);	
	}
	
}
