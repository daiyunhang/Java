package dd_04_03_插入排序;

import java.util.Arrays;
import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
		//随机乱序数组
		int[] a = suiJi();
		System.out.println(Arrays.toString(a));
		System.out.println("-------------------");
		sort(a);
		System.out.println("-------------------");
		System.out.println(Arrays.toString(a));
	}

	

	private static int[] suiJi() {
		/**
		 * 1.随机长度5+[0,6),存到变量len
		 * 2.新建len长度的int[]数组存到变量a
		 * 3.遍历填入100内随机值
		 * 4.返回数组a
		 * */
		
		int len = 5 + new Random().nextInt(6);
		int[] a = new int[len];
		for(int i=0; i<a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		return a;
	}
	private static void sort(int[] a) {
		/**
		 * 插入排序
		 * [38, 95, 45, 30, 32, 65, 76, 77]
		 * 
		 * *) 先认为第一个值是有序数字序列
		 * *) 从第二个值开始，把每个值，向前插入到正确位置
		 * 
		 * *)插入过程
		 *   *) j循环从i-1向前递减
		 *   *) 如果j位置>j+1位置值
		 *   	*) j和j+1位置交换
		 *   *) 否则，中断j循环
		 * */
		
		for(int i=1; i<a.length; i++) {
			//j循环作用：把i位置值向前插入正确位置
			for(int j=i-1; j>=0; j--) {
				//j位置值>j+1位置值
				if(a[j] > a[j+1]) {
					swap(a, j, j+1);//小值往前换
				}else {
					//数据已经插好
					break;
				}
			}
//			System.out.println(Arrays.toString(a));
		}
		
	}



	private static void swap(int[] a, int j, int i) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
		
	}
	

}
