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
				System.out.println("抽象类不能创建实例");
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
		//调用父类中定义的通用方法
		//执行时，执行子类中实现的方法
		c.draw();
			
		
		//c引用的对象，真实类型是Line类型
		if(c instanceof Line) {
			Line line = (Line) c;
			line.length();
			//向下转型，转回成Line类型
			//强制转型
		}

		new Scanner(System.in).nextLine();
		c.clear();
	}
}
