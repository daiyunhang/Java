package dd_05_04_�ݹ���쳲���������;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("��ڼ���쳲���������");
		int n = new Scanner(System.in).nextInt();
		long r = f(n);
//		long r = g(n);
		System.out.println(r);
	}
	
	private static long g(int n) {
		/**
		 *��ѭ���������εݹ���� 
		 * */
		long a=1;
		long b=1;
		for(int i=3; i<n; i++) {
			b=a+b;
			a=b-a;
		}
		
		return b;
	}

	private static long f(int n) {
		//������⣬��һ���͵ڶ�����֪��1
		if(n==1||n==2) {
			return 1;
		}
		return f(n-1) + f(n-2);
	}
	
	
}
