package dd_02_06_ѡ��˵�;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		outer://ѭ������
		while(true) {
			//��ʾ�˵�
			showMenu();
			//��ȡѡ���ֵ
			int c = new Scanner(System.in).nextInt();
			switch(c) {
			case 1: f1();break;
			case 2: f2();break;
			case 3: f3();break;
			case 4: f4();break;
			case 5: f5();break outer;
			default:
				f6();
			}
		}		
	}


	private static void showMenu() {
		System.out.println("-------------------------");
		System.out.println("����ʶ�𱻹ھ��ǣ�");
		System.out.println("1.����");
		System.out.println("2.����ʱ");
		System.out.println("3.Ӣ����");
		System.out.println("4.���޵���");
		System.out.println("5.�й�");
		System.out.println("-------------------------");
		System.out.print("ѡ��");
	}


	private static void f1() {
		System.out.println("��ѡ���˷���");
	}

	private static void f2() {
		System.out.println("��ѡ���˱���ʱ");
	}

	private static void f3() {
		System.out.println("��ѡ����Ӣ����");
	}

	private static void f4() {
		System.out.println("��ѡ���˿��޵���");
	}

	private static void f5() {
		System.out.println("��ѡ���˴������");
	}

	private static void f6() {
		System.out.println("û�����ѡ�������ѡ��");
	}	
}
