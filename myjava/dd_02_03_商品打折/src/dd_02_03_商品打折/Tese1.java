package dd_02_03_��Ʒ����;

import java.util.Scanner;

public class Tese1 {
	public static void main(String[] args) {
		System.out.print("����ԭ�ۣ�");
		double p = new Scanner(System.in).nextDouble();
		
		//ԭ��p��ֵ�����ݵ�discount()�����������ۿۼ�
		//�õ������ķ���ֵ�����浽����p
		p = discount(p);
		System.out.println("���ռ۸�" + p);
		
	}
	static double discount(double p) {
		// �����ۿ��ʱ���r  1,0.95, 0.9, 0.xx
		double r = 1;
		//����ԭ�۲���p�ķ�Χ������r���и���ͬ��ֵ ,�����ۿۼ۲�����
		
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
