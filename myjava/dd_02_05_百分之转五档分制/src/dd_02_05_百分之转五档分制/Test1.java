package dd_02_05_�ٷ�֮ת�嵵����;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		
		System.out.print("����ٷ�֮������");
		int s = new Scanner(System.in).nextInt();
		
		if(s<0 || s>100) {
			System.out.println("������� ");
			return;//����
		}
		
		//��s��ֵ���ݵ�f()���������嵵���������õ������ķ���ֵ�浽����r
		char r = f(s);
		System.out.println(r);
		
	}
	
	static char f(int s) {
		//����������
		char r = 'A';
		
		//�ж�s��ֵ
		switch(s/10) {
		case 10:
		case 9:
			r = 'A';
			break;
		case 8:case 7:
			r = 'B';
			break;
		case 6:
			r = 'C';
			break;
		case 5:case 4:case 3:case 2:
			r = 'D';
			break;
		case 1:case 0:
			r = 'E';
		}
		
		return r;
		
	}
	
}
