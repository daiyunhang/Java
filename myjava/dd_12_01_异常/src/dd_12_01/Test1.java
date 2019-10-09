package dd_12_01;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		while(true) {
			try {
				f();
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("输入两个！");
			} catch(ArithmeticException e) {
				System.out.println("不能除0！");
			} catch(Exception e) {
				System.out.println("错误，请重试！");
			} finally {
				//不管出错不出错，都执行
				System.out.println("---------------------");
			}
		} 
	}

	private static void f() {
		/*
		 * "6435,45" -->["6435","45"] 
		 * -->
		 * 6435
		 * 45
		 */
		System.out.print("输入逗号隔开的两个正数");
		String s = new Scanner(System.in).nextLine();
		String[] a = s.split(",");
		int n1 = Integer.parseInt(a[0]);
		int n2 = Integer.parseInt(a[1]);
		int r = n1/n2;
		System.out.println(r);
		
	}
}
