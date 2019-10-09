package dd_01_05_平年闰年;

import java.util.Scanner;

public class Test4 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.print("输入年号： ");
		int y = new Scanner(System.in).nextInt();
		
		/**
		 * 把年号y传递到runNian()方法进行运算
		 * 在判断该方法的返回值是真是假
		 * */
		boolean b = runNian(y);
		
		if(b) {
			System.out.println("闰年");
		}else {
			System.out.println("平年");
		}
		
		
		System.out.println(y);
		
	}
	
	static boolean runNian(int y) {
		//y能被4整除
		if(y%4 == 0) {
			//能被4整除的情况下，在判断不能被100整除
			if(y%100 != 0) {
				return true;
			}
		}
		//y能被400整除
		if(y%400 == 0) {
			return true;
		}
		
		return false;
	}
	
	
	
	
}
