package dd_11_01_����;

import java.util.LinkedList;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("��ڼ�������");
		int n = new Scanner(System.in).nextInt();
		
		long r = f(n);
		System.out.println(r);
	}

	private static long f(int n) {
		/*
		 * ׼����������
		 * 3
		 * --------
		 * 5
		 * --------
		 * 7
		 * --------
		 * 3,5,7,9,15,
		 */
		//������������
		LinkedList<Long> list3 = new LinkedList<>();
		LinkedList<Long> list5 = new LinkedList<>();
		LinkedList<Long> list7 = new LinkedList<>();
		
		list3.add(3L);
		list5.add(5L);
		list7.add(7L);
		
		long r = 0;//��������ÿ����õĳ���
		
		//�ӵ�1���󵽵�n��
		for(int i=1; i<n; i++) {
			//����ͷ��ֵ
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
