package dd_04_04_冒泡排序;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		
		int[] a = suiJi();
		System.out.println(Arrays.toString(a));
		System.out.println("---------------------");
		sort(a);
		System.out.println("---------------------");
		System.out.println(Arrays.toString(a));
		
		
	}

	private static int[] suiJi() {
		int len = 5 + new Random().nextInt(6);
		int[] a = new int[len];
		for(int i=0; i<a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		return a;
	}

	private static void sort(int[] a) {
		for(int i=0; i<a.length; i++) {
			boolean flag = false; //没有交换数据 -----> 如果排序提前完成后边的不需要执行
			
			//j循环作用：把较小值向前换，最小值换到i位置
			for(int j=a.length-1; j>i; j--) {
				//j-1位置值>j位置值
				if(a[j-1]>a[j]) {
					swap(a,j-1,j);
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
			System.out.println(Arrays.toString(a));
		}
		
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
		
	}
	
}
