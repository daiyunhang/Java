package dd_12_01;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		System.out.print("��������������");
		double a = new Scanner(System.in).nextDouble();
		double b = new Scanner(System.in).nextDouble();
		try {
			double r = divide(a,b);
			System.out.println(r);
		} catch (ArithmeticException e) {
			System.out.println("���ܳ�0�������ǵĴ�");
		}
		
	}

	private static double divide(double a, double b) {
		if(b == 0) {
			//�½��쳣����
			ArithmeticException e = new ArithmeticException("/ by zero");
			//���쳣�����׻ص�����λ��
			throw e;
		}
		return a/b;
	}
}
