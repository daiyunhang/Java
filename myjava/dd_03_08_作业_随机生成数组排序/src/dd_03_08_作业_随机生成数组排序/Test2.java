package dd_03_08_��ҵ_���������������;

import java.util.Arrays;
import java.util.Random;

public class Test2 {
	public static void main(String[] args) {
		//ѡ������
		
		//����suiJi()���������һ����������
		
		int[] a = suiJi();
		System.out.println(Arrays.toString(a));
		System.out.println("---------------------");
		sort(a);//���򷽷�
		System.out.println("---------------------");
		System.out.println(Arrays.toString(a));
		
	}

	private static int[] suiJi() {
		/**
		 * 1.������Χ5+[0,6)��Χ��������ȴ浽����len
		 * 2.�½�len���ȵ�int[]����
		 * 3.�������飬����100�����ֵ
		 * 4.��������a
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
			//i��ĩβ��Χ��ѡ����Сֵλ��
			int index = min(a,i);
			//indexλ�õ���Сֵ��������iλ��
			swap(a,i,index);
		}
	}

	private static int min(int[] a, int i) {
		/**
		 * [36, 36, 3, 86, 36, 22, 86, 3, 20]
		 * */
		int m = i; //����iλ����С�������Ҹ�Сֵ
		for(int j=i+1; j<a.length; j++) {
			//�ҵ�jλ�ø�С
			if(a[j] < a[m]) {
				m=j;//��m��λ��jλ��
			}
		}
		return m;
	}

	private static void swap(int[] a, int i, int j) {
		//a ������   i���±�  j���±���Сֵ��
		int tt = a[i];
		a[i] = a[j];
		a[j] = tt;
	}

}

	

