package dd_02_04_个人所得税;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("工资：");
		double s = new Scanner(System.in).nextDouble();
		
		//把s传递到grsds()方法，来计算个人所得税，得到方法的返回值，保存到变量tax
		double tax = grsds(s);
		System.out.println("应缴纳个人所得税：" + tax);
			
		
	}
	
	static double grsds(double s) {
		
		
		if(s <= 3500) {
			return 0;
		}
		
		//工资抛掉3500
		s -= 3500; // s= s-3500;
		
		//定义税率变量r和速算扣除变量k
		double r = 0;
		int k = 0;
//		
//		switch(s) {
//			case s <= 1500:
//				r = 0.03;
//				k = 0;
//				break;
//			case s <= 4500:
//				r = 0.03;
//				k = 0;
//				break;
//			case s <= 9000:
//				r = 0.03;
//				k = 0;
//				break;
//			case s <= 35000:
//				r = 0.03;
//				k = 0;
//				break;
//			case s <= 55000:
//				r = 0.03;
//				k = 0;
//				break;
//			case s <= 80000:
//				r = 0.03;
//				k = 0;
//		};
//		
//		懒得写了
		
		return s*r - k;
	}

}
