package dd_03_07_数组;

import java.util.Arrays;
import java.util.Random;

public class Test2 {
	public static void main(String[] args) {
		//新建10个长度的int[]数组，
		//地址存到变量a
		
		int[] a = new int[10];
		//遍历，填入100内随机值
		for(int i=0; i<a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		System.out.println(Arrays.toString(a));

		
		System.out.println("---------交换3,4位置的值-----------");
		
		swap(a,3,4);
		System.err.println(Arrays.toString(a));
		
		
		System.out.println("----------获得最小值的位置下标----------------");
		int index = min(a);
		System.out.println("最小值位置："+ index);
		
		
		//最小值排列到第一位
		swap(a,0,index);
		System.out.println(Arrays.toString(a));
		
	}

	private static int min(int[] a) {
		/**
		 * m = 0
		 * [54, 99, 89, 92, 7, 87, 66, 66, 37, 20]
		 * 		i
		 * 
		 * *)假设0位置是最小值
		 * *)从1位置向后找比m位置更小值
		 * *)找到更小值，m定位到i位置
		 * 
		 * 1.定一下标 m=0
		 * 2.i循环从1到<a.length
		 * 		3.如果i位置值<m位的值
		 * 			4.把m修改成i的值
		 * 5.返回m的值	
		 * */
		int m = 0;
		for(int i=1; i<a.length; i++) {
			if(a[i] < a[m]) {
				m = i;
			}
		}
		
		return m;
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	
}
