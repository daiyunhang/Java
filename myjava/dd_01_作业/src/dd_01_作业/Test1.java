package dd_01_作业;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//根据圆的半径求周长与面积  2πr 和 πrr
		System.out.print("输入圆的半径");
		int y = new Scanner(System.in).nextInt();
		
		f(y);
		
	}
	
	static void f(int y) {
		double a = 2d*3.14*y;
		double b = 3.14d * y * y;
		
		System.out.println("周长:"+a+"面积:"+b);
	}
	
}
