package dd_09_02_字符串;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.print("输入email：");
		String e = new Scanner(System.in).nextLine();
		String n = getName(e);
		System.out.println(n);
	}

	private static String getName(String e) {
		/*
		 * asdf@asdasd.com
		 * |   | 
		 * 0   4
		 * 
		 * 1.找"@"的位置存放到index
		 * 2.如果index==-1,并返回"格式错误"
		 * 3.截取[0,index),并返回
		 */
		e = e.trim();
		int index = e.indexOf("@"); 
		if(index == -1) {
			return "格式错误";
		}
		return e.substring(0,index);	
	}
	
}
