package dd_09_06_��ҵ_�����Ӵ�;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("�����ַ���:");
		String s = new Scanner(System.in).nextLine();
		System.out.println("���ҵ��ִ�:");
		String t = new Scanner(System.in).nextLine();
		
		int[] a = find(s,t);
		System.out.println(Arrays.toString(a));
	}

	private static int[] find(String s, String t) {
		/*
		 * aaaaaaaaaaaaaaaa
		 * a
		 * 
		 * [1,4,7,
		 */
		//�����㹻��������
		int[] a = new int[s.length()];
		int i = 0; //������������a
		
		//������Ǵ��Ŀ�ʼ�����
		//�������ҵ����±�λ��
		int index = 0;
		
		//��ѭ�������
		while(true) {
			//��index�����
			index = s.indexOf(t, index);
			if(index == -1) {
				break;
			}
			a[i] = index;
			i++;
			index++;
			if(index >= s.length()) {
				break;
			}
		}
		return Arrays.copyOf(a, i);
	}
}
