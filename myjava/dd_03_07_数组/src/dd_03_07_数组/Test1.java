package dd_03_07_数组;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
	
		/**
		 * ---------三种创建数组的方式--------
		 * 
		 * int[] a = new int[5];
		 * char[] b = {'a','b','c'};
		 * a = new int[]{1,2,3,4,5,6};
		 * */
		
		
		int[] a = new int[5];
		
		char[] b = {'a','b','c'};
		
		/**
		 * Arrays.toString(a);
		 * 把数组中的值，连接成字符串
		 * "[0,0,0,0,0,]"
		 * */	
	
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		//让
		a = new int[]{1,2,3,4,5,6};
		System.out.println(Arrays.toString(a));
		
		
	}
	
	

}
