package dd_10_05_��ҵ_�����ַ���2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("�����ַ���:");
		String s = new Scanner(System.in).nextLine();
		System.out.println("���ҵ��ִ�:");
		String t = new Scanner(System.in).nextLine();
		
		LinkedList<Integer> a = find(s,t);
		System.out.println(a);
	}

	private static LinkedList<Integer> find(String s, String t) {
		/*
		 * aaaaaaaaaaaaaaaa
		 * a
		 * 
		 * [1,4,7,
		 */
		//�����㹻��������
		LinkedList<Integer> list = new LinkedList<>();
		
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
			list.add(index);
			index++;
			if(index >= s.length()) {
				break;
			}
		}
		return list;
	}
}
