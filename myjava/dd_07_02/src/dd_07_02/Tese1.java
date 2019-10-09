package dd_07_02;

import java.util.Random;
import java.util.Scanner;

public class Tese1 {
	public static void main(String[] args) {
		while(true) {
			int r = new Random().nextInt(4);
			switch(r) {
			case 0:
				Shape s = new Shape();
				f(s);
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

	private static void f(Circle c) {
		new Scanner(System.in).nextLine();
		c.draw();
		new Scanner(System.in).nextLine();
		c.clear();
	}
	private static void f(Line c) {
		new Scanner(System.in).nextLine();
		c.draw();
		new Scanner(System.in).nextLine();
		c.clear();
	}
	private static void f(Square c) {
		new Scanner(System.in).nextLine();
		c.draw();
		new Scanner(System.in).nextLine();
		c.clear();
	}
	private static void f(Shape c) {
		new Scanner(System.in).nextLine();
		c.draw();
		new Scanner(System.in).nextLine();
		c.clear();
	}
}
