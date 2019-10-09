package dd_16_01_反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * "java.lang.String"
		 * "java.util.Date"
		 * "java.util.ArrayList"
		 * "java.io.file"
		 * "java.io.FileInputStream"
		 * 
		 */
		System.out.println("输入类名: ");
		String s = new Scanner(System.in).nextLine();
		Class<?> c = Class.forName(s);
		
		System.out.println(c.getPackage().getName());
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		
		
		System.out.println("--成员变量------------------------------");
		f1(c);

		System.out.println("--构造方法------------------------------");
		f2(c);
		
		System.out.println("--方法------------------------------");
		f3(c);
		
	}

	private static void f1(Class<?> c) {
		Field[] a = c.getDeclaredFields();
		/*
		 * public static final Date d
		 */
		for(Field f : a) {
			//修饰符
			String m = Modifier.toString(f.getModifiers());
			//类型
			String t = f.getType().getSimpleName();
			//变量名
			String n = f.getName();
			
			System.out.println(m+"---"+ t +"--- "+ n);
			
			
		}
		
	}

	private static void f2(Class<?> c) {
		/*
		 * public A(int a ,String b) throws A,B,C
		 */
		Constructor<?>[] a = c.getDeclaredConstructors();
		for(Constructor<?> t : a) {
			//得到修饰符
			String s = Modifier.toString(t.getModifiers());
			//构造方法名就是类名
			String n = c.getSimpleName();
			//参数类型列表
			Class<?>[] p = t.getParameterTypes();
			
			System.out.println(s+"---"+n+"---"+"("+ Arrays.toString(p) +")");
		}
		
	}

	private static void f3(Class<?> c) {
		/*
		 * public String A(int a ,String b) throws A,B,C
		 */
		Method[] a = c.getDeclaredMethods();
		for(Method t : a) {
			//得到修饰符
			String s = Modifier.toString(t.getModifiers());
			//返回类型
			String r = t.getReturnType().getSimpleName();
			//方法名
			String n = c.getName();
			//参数类型列表
			Class<?>[] p = t.getParameterTypes();
			
			System.out.println(s+"---"+r+" "+n+"---"+"("+ Arrays.toString(p) +")");
		}
	}
}




























