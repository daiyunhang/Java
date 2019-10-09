package dd_07_04_快速排序;

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
		sort(a, 0, a.length-1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if(lo >= hi) 
		{
			return;
		}
		
		int i=lo;
		int j=hi;
		int t=a[lo];
		
		while(i<j) {
			//j向左找<=t的值
			while(a[j]>t && j>i) {
				j--;
			}
			a[i] = a[j];
			//i向右找>t的值
			while(a[i]<=t && j>i) {
				i++;
			}
			a[j] = a[i];
		}
		a[i] = t;
//		System.out.println(t);
//		System.out.println(Arrays.toString(a));
		sort(a, lo, i-1);
		sort(a, i+1, hi);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
