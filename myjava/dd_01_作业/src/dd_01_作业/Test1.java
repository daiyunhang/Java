package dd_01_��ҵ;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//����Բ�İ뾶���ܳ������  2��r �� ��rr
		System.out.print("����Բ�İ뾶");
		int y = new Scanner(System.in).nextInt();
		
		f(y);
		
	}
	
	static void f(int y) {
		double a = 2d*3.14*y;
		double b = 3.14d * y * y;
		
		System.out.println("�ܳ�:"+a+"���:"+b);
	}
	
}
