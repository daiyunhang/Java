package dd_01_03;


import java.math.BigDecimal;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("���뽵��ʱ��(��) : ");
		//�õ������ֵ�����浽����t
		double t = new Scanner(System.in).nextDouble();
		//�׹�ʽ���������룬���浽����b
//		double d = 0.5*9.8*t*t;
		
		BigDecimal a = BigDecimal.valueOf(4.9);
		BigDecimal b = BigDecimal.valueOf(t);
		
//		double d = a.multiply(b).multiply(b).doubleValue();
		double d = a.multiply(b.pow(2)).doubleValue();//pow() ��ƽ��
		
		
		System.out.println(t+"�뽵����"+d+"��");
//		System.out.println(t+"�뽵����"+d+"��");
		
	}
}
