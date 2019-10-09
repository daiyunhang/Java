package dd_03_05_质数;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		System.out.print("输入整数n，求n内质数的数量：");
		int n = new Scanner(System.in).nextInt();
		
		//n传递到prime()方法，求质数数量
		int r = prime(n);
		System.out.println(r);
	}

	private static int prime(int n) {
		
		if(n < 2) {
			return 0;	
		}
		
		//计数变量
		int c = 0;
		
		//2到n范围内，找质数
		outer:
		for(int i=2; i<=n; i++) {
			//i时候是质数
			//2到<根号i+1范围内，找到能把i整除的值
			
			double max = Math.sqrt(i) + 1;
			for(int j=2; j<max; j++) {
				//i能被j整除
				if(i%j == 0) {
					//i不是质数,跳到i++,判断下一个i值是否是质数
					continue outer;
				}
			}
			//i是质数，计数增加
			c++;
		}
		return c;
	}
	
	

	
	
	

}
