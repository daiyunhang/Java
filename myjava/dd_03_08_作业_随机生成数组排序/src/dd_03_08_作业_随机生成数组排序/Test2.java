package dd_03_08_作业_随机生成数组排序;

import java.util.Arrays;
import java.util.Random;

public class Test2 {
	public static void main(String[] args) {
		//选择排序
		
		//调用suiJi()方法，获得一个乱序数组
		
		int[] a = suiJi();
		System.out.println(Arrays.toString(a));
		System.out.println("---------------------");
		sort(a);//排序方法
		System.out.println("---------------------");
		System.out.println(Arrays.toString(a));
		
	}

	private static int[] suiJi() {
		/**
		 * 1.产生范围5+[0,6)范围的随机长度存到变量len
		 * 2.新建len长度的int[]数组
		 * 3.遍历数组，填入100内随机值
		 * 4.返回数组a
		 * */
		int len = 5+new Random().nextInt(6);
		int[] a = new int[len];
		for(int i=0; i<a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		return a;
	}

	private static void sort(int[] a) {
		/**
		 * [36, 36, 3, 86, 36, 22, 86, 3, 20]
		 * */
		for(int i=0; i<a.length; i++) {
			//i到末尾范围，选择最小值位置
			int index = min(a,i);
			//index位置的最小值，交换到i位置
			swap(a,i,index);
		}
	}

	private static int min(int[] a, int i) {
		/**
		 * [36, 36, 3, 86, 36, 22, 86, 3, 20]
		 * */
		int m = i; //假设i位置最小，往后找更小值
		for(int j=i+1; j<a.length; j++) {
			//找到j位置更小
			if(a[j] < a[m]) {
				m=j;//把m定位到j位置
			}
		}
		return m;
	}

	private static void swap(int[] a, int i, int j) {
		//a 是数组   i是下标  j是下标最小值；
		int tt = a[i];
		a[i] = a[j];
		a[j] = tt;
	}

}

	

