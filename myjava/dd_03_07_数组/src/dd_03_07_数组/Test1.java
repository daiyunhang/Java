package dd_03_07_����;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
	
		/**
		 * ---------���ִ�������ķ�ʽ--------
		 * 
		 * int[] a = new int[5];
		 * char[] b = {'a','b','c'};
		 * a = new int[]{1,2,3,4,5,6};
		 * */
		
		
		int[] a = new int[5];
		
		char[] b = {'a','b','c'};
		
		/**
		 * Arrays.toString(a);
		 * �������е�ֵ�����ӳ��ַ���
		 * "[0,0,0,0,0,]"
		 * */	
	
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		//��
		a = new int[]{1,2,3,4,5,6};
		System.out.println(Arrays.toString(a));
		
		
	}
	
	

}
