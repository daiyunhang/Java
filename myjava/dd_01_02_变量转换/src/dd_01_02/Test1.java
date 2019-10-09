package dd_01_02;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("输入整数a: ");
		int a = new Scanner(System.in).nextInt();
		
		System.out.print("输入整数b: ");
		int b = new Scanner(System.in).nextInt();
		
		int c = a;
		a = b;
		b = c;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}
