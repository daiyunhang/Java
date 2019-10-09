package dd_02_06_选项菜单;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		outer://循环命名
		while(true) {
			//显示菜单
			showMenu();
			//获取选择的值
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
		System.out.println("本届识别被冠军是：");
		System.out.println("1.法国");
		System.out.println("2.比利时");
		System.out.println("3.英格兰");
		System.out.println("4.克罗地亚");
		System.out.println("5.中国");
		System.out.println("-------------------------");
		System.out.print("选择：");
	}


	private static void f1() {
		System.out.println("您选择了法国");
	}

	private static void f2() {
		System.out.println("您选择了比利时");
	}

	private static void f3() {
		System.out.println("您选择了英格兰");
	}

	private static void f4() {
		System.out.println("您选择了克罗地亚");
	}

	private static void f5() {
		System.out.println("您选择了错误国家");
	}

	private static void f6() {
		System.out.println("没有这个选项，请重新选择");
	}	
}
