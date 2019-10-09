package dd_05_01_二分法查找;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		int[] a = suiJi();
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		System.out.print("查找的目标值：");
		int t = new Scanner(System.in).nextInt();
		//二分法查找
		int index = binarySearch(a,t);
		System.out.println(index);
	}

	private static int[] suiJi() {
		int len = 5 + new Random().nextInt(6);
		int[] a = new int[len];
		for(int i=0; i<a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		
		return a;
	}
	
	private static int binarySearch(int[] a, int t) {
		/**
		 * a
		 * 
		 * [27, 52, 52, 69, 76]
		 * 
		 * 1.定义三个下标
		 * 	 lo=0
		 * 	 hi=a.length-1
		 * 2.当lo<hi
		 * 		3.计算中间位置mid=(lo+hi)/2
		 * 	   	4.mid位置的值>t,hi定位到mid-1位置
		 * 		5.mid位置的值<t,lo定位到mid+1位置
		 * 		6.否则，直接返回mid值
		 * 7.找不到数据，返回一个特殊值-1
		 * */
		
		//--------------讲师的方法
		int lo = 0;
		int hi = a.length-1;
		int mid;
		while(lo<=hi) {
			mid = (lo+hi)/2;
			if(a[mid]>t) {
				hi = mid-1;
			}else if(a[mid]<t) {
				lo = mid+1;
			}else {
				return mid;
			}
		}
		//---------------自己的方法
//		for(int i=0; i<a.length; i++) {
//			if(a[i] == t) {
//				return i;
//			}
//		}
		
		
		return -1;
	}

}
