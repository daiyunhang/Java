package dd_02_03_商品打折;

import java.util.Scanner;

public class Tese1 {
	public static void main(String[] args) {
		System.out.print("输入原价：");
		double p = new Scanner(System.in).nextDouble();
		
		//原价p的值，传递到discount()方法来计算折扣价
		//得到方法的返回值，保存到变量p
		p = discount(p);
		System.out.println("最终价格：" + p);
		
	}
	static double discount(double p) {
		// 定义折扣率变量r  1,0.95, 0.9, 0.xx
		double r = 1;
		//根据原价参数p的范围，来给r进行赋不同的值 ,计算折扣价并返回
		
		if(p > 5000) {
			r = 0.75;
		}else if(p > 3000) {
			r = 0.8;
		}else if(p>1000) {
			r = 0.9;
		}else if(p>500) {
			r = 0.95;
		}
		return p*r;
	}
	
	
}
