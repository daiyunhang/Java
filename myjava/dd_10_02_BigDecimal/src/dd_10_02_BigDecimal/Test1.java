package dd_10_02_BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入两个浮点数：");
		double a = new Scanner(System.in).nextDouble();
		double b = new Scanner(System.in).nextDouble();
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		
		System.out.println("-------------------------------------------");
	
		BigDecimal bd1 = BigDecimal.valueOf(a);
		BigDecimal bd2 = BigDecimal.valueOf(b);
		BigDecimal bd3;
		
		bd3 = bd1.add(bd2);
		System.out.println(bd3.doubleValue());
		
		bd3 = bd1.subtract(bd2);
		System.out.println(bd3.doubleValue());
		
		bd3 = bd1.multiply(bd2);
		System.out.println(bd3.doubleValue());
		
		bd3 = bd1.divide(bd2, 50, BigDecimal.ROUND_HALF_UP);
		System.out.println(bd3.doubleValue());
		System.out.println(bd3.toString());
		
		bd3 =  bd3.setScale(-2, BigDecimal.ROUND_HALF_UP);
		System.out.println(bd3.doubleValue());
	}
	
}
