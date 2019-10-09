package dd_16_01_反射;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * java.lang.Integer
		 * java.util.ArrayList
		 * java.util.Date
		 */
		System.err.println("输入类名: ");
		String s = new Scanner(System.in).nextLine();
		Class<?> c = Class.forName(s);
		
		Object o1;
		Object o2;
		
		try {
			//新建实例,并执行无参构造
			o1 = c.newInstance();
			System.out.println(o1);
		} catch (Exception e) {
			System.out.println("无法执行无参构造");
		}
		
		try {
			//新建实例,并执行int参数构造
			Constructor<?> t = c.getConstructor(int.class);
			o2 = t.newInstance(5);
			System.out.println(o2);
		} catch (Exception e) {
			System.out.println("不能执行int构造");
		}
	}
	
}
