package dd_03_01_循环嵌套;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	

	



	private static void f4() {
		/**
		 * i
		 *  1     *
		 *  2    ***
		 *  3   *****
		 *  4  *******
		 *  5 *********
		 *  	12345 j
		 *  
		 * */
		
		System.out.print("输入大小：");
		int n = new Scanner(System.in).nextInt();
		
		//1到n行
		for(int i=1; i<=n; i++){
			//n-1个空格
			for(int j=1; j<=n-i; j++){
				System.out.print(" ");
			}
			//2*n-1个星号
			for(int j=1; j<=2*i-1; j++){
				System.out.print("*");
			}
			System.out.println();//补换行符号
		}
	}




	private static void f1() {

		for(int i=1; i<=3; i++){
			for(int j=9; j>=7; j--){
				System.out.println(i+ "," + j);
			}
		}
	}
	
	private static void f2() {
		/**
		 * i
		 *  1 *****
		 *  2 *****
		 *  3 *****
		 *  4 *****
		 *  5 *****
		 *  	12345 j
		 *  
		 * */
		
		System.out.print("输入大小：");
		int n = new Scanner(System.in).nextInt();
		
		//1到n行
		for(int i=1; i<=n; i++){
			//在一行中打印1到n个星号
			for(int j=1; j<=n; j++){
				System.out.print("*");
			}
			System.out.println();//补换行符号
		}
	}

	private static void f3() {
		/**
		 * i
		 *  1 *
		 *  2 **
		 *  3 ***
		 *  4 ****
		 *  5 *****
		 *  	12345 j
		 *  
		 * */
		System.out.print("输入大小：");
		int n = new Scanner(System.in).nextInt();
		
		//1到n行
		for(int i=1; i<=n; i++){
			//在一行中打印1到n个星号
			for(int j=1; j<=i; j++){
				System.out.print("*");
			}
			System.out.println();//补换行符号
		}
		
	}
}
