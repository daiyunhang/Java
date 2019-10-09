package dd_04_05_作业;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		int[] a = suiJi();
		int[] b = suiJi();
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		int[] arr = heBing(a,b);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] suiJi() {
		int len = 5 + new Random().nextInt(6);
		int[] a = new int[len];
		for(int i=0; i<a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		return a;
	}

	private static int[] heBing(int[] a, int[] b) {
		/**
		 * 
		 * */

		
		
		
		
		//新建int[]数组，长度是a，b长度的和
		int[] c = new int[a.length+b.length];
		for(int i=0,j=0,k=0; i<c.length; i++) {
			if(j>=a.length) {
//				c[i] = b[k++];
//				continue;
				System.arraycopy(b, k, c, i, b.length-k);
				break;
			}
			if(k>=b.length) {
//				c[i] = a[j++]; 
//				continue;
				System.arraycopy(a, j, c, i, a.length-j);
				break;
			}
			if(a[j] <b[k]) {
				c[i] = a[j++];
			}else {
				c[i] = b[k++];
			}
		}
		
		
//		int[] c = new int[a.length+b.length];
//		for(int i=0,j=0,k=0; i<c.length; i++) {
//			if(j>=a.length) {
//				c[i] = b[k++];
//				continue;
//			}
//			if(k>=b.length) {
//				c[i] = a[j++]; 
//				continue;
//			}
//			if(a[j] <b[k]) {
//				c[i] = a[j++];
//			}else {
//				c[i] = b[k++];
//			}
//		}
		return c;
	}




	
}
