package dd_05_01_���ַ�����;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		int[] a = suiJi();
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		System.out.print("���ҵ�Ŀ��ֵ��");
		int t = new Scanner(System.in).nextInt();
		//���ַ�����
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
		 * 1.���������±�
		 * 	 lo=0
		 * 	 hi=a.length-1
		 * 2.��lo<hi
		 * 		3.�����м�λ��mid=(lo+hi)/2
		 * 	   	4.midλ�õ�ֵ>t,hi��λ��mid-1λ��
		 * 		5.midλ�õ�ֵ<t,lo��λ��mid+1λ��
		 * 		6.����ֱ�ӷ���midֵ
		 * 7.�Ҳ������ݣ�����һ������ֵ-1
		 * */
		
		//--------------��ʦ�ķ���
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
		//---------------�Լ��ķ���
//		for(int i=0; i<a.length; i++) {
//			if(a[i] == t) {
//				return i;
//			}
//		}
		
		
		return -1;
	}

}
