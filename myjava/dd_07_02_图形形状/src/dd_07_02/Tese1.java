package dd_07_02;

import java.util.Random;
import java.util.Scanner;

public class Tese1 {
	private static final String Line = null;

	public static void main(String[] args) {
		while(true) {
			int r = new Random().nextInt(4);
			switch(r) {
			case 0:
//				Shape s = new Shape();
//				f(s);
				System.out.println("�����಻�ܴ���ʵ��");
				break;
			case 1:
				Line l = new Line();
				f(l);
				break;
			case 2:
				Square q = new Square();
				f(q);
				break;
			case 3:
				Circle c = new Circle();
				f(c);
				break;
			}
		}
	}

	private static void f(Shape c) {
		new Scanner(System.in).nextLine();
		//���ø����ж����ͨ�÷���
		//ִ��ʱ��ִ��������ʵ�ֵķ���
		c.draw();
			
		
		//c���õĶ�����ʵ������Line����
		if(c instanceof Line) {
			Line line = (Line) c;
			line.length();
			//����ת�ͣ�ת�س�Line����
			//ǿ��ת��
		}

		new Scanner(System.in).nextLine();
		c.clear();
	}
}
