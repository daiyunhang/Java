package dd_02_01_int拆分四字节;

import java.util.Scanner;

public class Test1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("输入整数:");
		int n = new Scanner(System.in).nextInt();
		
		System.out.println("--拆分成四个byte值------");
		//把n的值传递到f1()方法进行拆分
		//在f1()方法中,直接打印显示拆分结果
		
		f1(n);
		
		
	}
	
	static void f1(int n) {
		
		/**
		 * 11001101 10011110 11100100 10010011
		 * 
		 * n的值,右移24,16,8,0位,再强转成byte类型
		 * */
		
		byte b1 = (byte)(n>>24);
		byte b2 = (byte)(n>>16);
		byte b3 = (byte)(n>>8);
		byte b4 = (byte)(n>>0);
		System.out.println("---------------");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println("---------------");
		
		/**
		 * 11001101
		 * 10011110
		 * 11100100
		 * 10010011
		 * */
		
		int r = 0;
		//字节值左移24再不带符号右移0,8,16,24
		//与r求位或, 结果再保存到r
		r = r | (b1<<24>>>0);
		r = r | (b2<<24>>>8);
		r = r | (b3<<24>>>16);
		r = r | (b4<<24>>>24);
		System.out.println(r);
		
		
		/**
		 * 255   0xff 0x000000ff
		 * */
		r = 0;
		//字节值与0x000000ff求位与
		//左移24,16,8,0位,与r求位或
		//结果再保存到r
		
		r = r | ((b1 & 0x000000ff) << 24);
		r = r | ((b2 & 0x000000ff) << 16);
		r = r | ((b3 & 0x000000ff) << 8);
		r = r | ((b4 & 0x000000ff) << 0);
		System.out.println("----------------------------------------");
		System.out.println(r);
		
	}

}
