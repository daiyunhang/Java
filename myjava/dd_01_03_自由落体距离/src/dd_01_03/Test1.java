package dd_01_03;


import java.math.BigDecimal;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("输入降落时间(秒) : ");
		//得到输入的值，保存到变量t
		double t = new Scanner(System.in).nextDouble();
		//套公式求出降落距离，保存到变量b
//		double d = 0.5*9.8*t*t;
		
		BigDecimal a = BigDecimal.valueOf(4.9);
		BigDecimal b = BigDecimal.valueOf(t);
		
//		double d = a.multiply(b).multiply(b).doubleValue();
		double d = a.multiply(b.pow(2)).doubleValue();//pow() 算平方
		
		
		System.out.println(t+"秒降落了"+d+"米");
//		System.out.println(t+"秒降落了"+d+"米");
		
	}
}
