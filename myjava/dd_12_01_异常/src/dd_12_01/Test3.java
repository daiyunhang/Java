package dd_12_01;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		System.out.print("输入两个浮点数");
		double a = new Scanner(System.in).nextDouble();
		double b = new Scanner(System.in).nextDouble();
		try {
			double r = divide(a,b);
			System.out.println(r);
		} catch (ArithmeticException e) {
			System.out.println("不能除0，是我们的错。");
		}
		
	}

	private static double divide(double a, double b) {
		if(b == 0) {
			//新建异常对象
			ArithmeticException e = new ArithmeticException("/ by zero");
			//把异常对象抛回到调用位置
			throw e;
		}
		return a/b;
	}
}
