package dd_05_03_递归求阶乘;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("输入整数求就成：");
		int n = new Scanner(System.in).nextInt();
		
		long r = f(n);
		System.out.println(r);
	}
	private static long f(int n) {
		//最简问题，n的0，0的阶乘已知是1
		if(n == 0) {
			return 1;
		}
		return n*f(n-1);
	}
	
}
