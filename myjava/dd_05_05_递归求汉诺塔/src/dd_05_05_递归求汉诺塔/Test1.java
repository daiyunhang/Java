package dd_05_05_递归求汉诺塔;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		System.out.print("基层汉诺塔：");
		int n = new Scanner(System.in).nextInt();
		
		f(n);
		
	}

	private static void f(int n) {
		f(n,"A","B","C");
		
	}

	private static void f(int n, String z1, String z2, String z3) {
		//最简问题，1层，从z1直接到z3
		if(n==1) {
			System.out.println(z1+"-->"+z3);
			return;
		}
		
		//上面的n-1，从z1经z3到z2
		f(n-1,z1,z3,z2);
		//最下面的一层，从z1直接到z3
		System.out.println(z1+"-->"+z3);
		//在z2上的n-1层，经z1到z3
		f(n-1,z2,z1,z3);
	}

}
