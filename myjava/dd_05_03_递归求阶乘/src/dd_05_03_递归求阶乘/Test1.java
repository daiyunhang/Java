package dd_05_03_�ݹ���׳�;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("����������ͳɣ�");
		int n = new Scanner(System.in).nextInt();
		
		long r = f(n);
		System.out.println(r);
	}
	private static long f(int n) {
		//������⣬n��0��0�Ľ׳���֪��1
		if(n == 0) {
			return 1;
		}
		return n*f(n-1);
	}
	
}
