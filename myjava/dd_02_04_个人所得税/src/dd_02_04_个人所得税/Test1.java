package dd_02_04_��������˰;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("���ʣ�");
		double s = new Scanner(System.in).nextDouble();
		
		//��s���ݵ�grsds()�������������������˰���õ������ķ���ֵ�����浽����tax
		double tax = grsds(s);
		System.out.println("Ӧ���ɸ�������˰��" + tax);
			
		
	}
	
	static double grsds(double s) {
		
		
		if(s <= 3500) {
			return 0;
		}
		
		//�����׵�3500
		s -= 3500; // s= s-3500;
		
		//����˰�ʱ���r������۳�����k
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
//		����д��
		
		return s*r - k;
	}

}
