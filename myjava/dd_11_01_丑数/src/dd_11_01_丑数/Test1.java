package dd_11_01_丑数;

import java.util.LinkedList;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("求第几个丑数");
		int n = new Scanner(System.in).nextInt();
		
		long r = f(n);
		System.out.println(r);
	}

	private static long f(int n) {
		/*
		 * 准备三个集合
		 * 3
		 * --------
		 * 5
		 * --------
		 * 7
		 * --------
		 * 3,5,7,9,15,
		 */
		//创建三个集合
		LinkedList<Long> list3 = new LinkedList<>();
		LinkedList<Long> list5 = new LinkedList<>();
		LinkedList<Long> list7 = new LinkedList<>();
		
		list3.add(3L);
		list5.add(5L);
		list7.add(7L);
		
		long r = 0;//用来保存每次求得的丑数
		
		//从第1个求到第n个
		for(int i=1; i<n; i++) {
			//访问头数值
			long a = list3.getFirst();
			long b = list5.getFirst();
			long c = list7.getFirst();
			r = Math.min(a, Math.min(b, c));
			if(r == a) list3.removeFirst();
			if(r == b) list5.removeFirst();
			if(r == c) list7.removeFirst();
			
			list3.add(r*3);
			list5.add(r*5);
			list7.add(r*7);
			
			
		}
		return r;
		
	}
}
