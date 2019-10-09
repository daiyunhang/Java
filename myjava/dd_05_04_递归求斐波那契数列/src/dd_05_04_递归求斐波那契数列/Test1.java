package dd_05_04_递归求斐波那契数列;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("求第几个斐波那契数：");
		int n = new Scanner(System.in).nextInt();
		long r = f(n);
//		long r = g(n);
		System.out.println(r);
	}
	
	private static long g(int n) {
		/**
		 *用循环代替两次递归调用 
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
		//最简问题，第一个和第二个已知是1
		if(n==1||n==2) {
			return 1;
		}
		return f(n-1) + f(n-2);
	}
	
	
}
