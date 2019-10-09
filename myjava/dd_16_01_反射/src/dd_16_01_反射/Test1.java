package dd_16_01_����;

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
		System.out.println("��������: ");
		String s = new Scanner(System.in).nextLine();
		Class<?> c = Class.forName(s);
		
		System.out.println(c.getPackage().getName());
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		
		
		System.out.println("--��Ա����------------------------------");
		f1(c);

		System.out.println("--���췽��------------------------------");
		f2(c);
		
		System.out.println("--����------------------------------");
		f3(c);
		
	}

	private static void f1(Class<?> c) {
		Field[] a = c.getDeclaredFields();
		/*
		 * public static final Date d
		 */
		for(Field f : a) {
			//���η�
			String m = Modifier.toString(f.getModifiers());
			//����
			String t = f.getType().getSimpleName();
			//������
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
			//�õ����η�
			String s = Modifier.toString(t.getModifiers());
			//���췽������������
			String n = c.getSimpleName();
			//���������б�
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
			//�õ����η�
			String s = Modifier.toString(t.getModifiers());
			//��������
			String r = t.getReturnType().getSimpleName();
			//������
			String n = c.getName();
			//���������б�
			Class<?>[] p = t.getParameterTypes();
			
			System.out.println(s+"---"+r+" "+n+"---"+"("+ Arrays.toString(p) +")");
		}
	}
}




























