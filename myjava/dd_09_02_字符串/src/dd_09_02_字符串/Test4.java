package dd_09_02_字符串;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		System.out.print("输入回文：");
		String s = new Scanner(System.in).nextLine();
		if(huiWen(s)) {
			System.out.println("是回文");
		}else {
			System.out.println("不是回文");
		}
	}

	private static boolean huiWen(String s) {
		/*
		 * asddsa
		 * i    j
		 * 
		 * 1.for循环i=0,n=末尾; 条件：i<j
		 * 		2.如果i位置字符和j位置字符不相等
		 * 			3.返回false
		 * 4.返回true 
		 */
		for(int i=0,j=s.length()-1; i<j; i++,j--) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			
		}
		return true;
	
	}
}
