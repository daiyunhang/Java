package dd_05_06_ʿ��;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		//�½�Soldier[]����
		Soldier[] a = new Soldier[5];
		for(int i=0;i<a.length;i++) {
			a[i] = new Soldier();
			a[i].id = i+1;
		}
		//ʿ����������0���ͼ�������
		while(Soldier.count != 0) 
		{
			for(int i=0;i<a.length;i++) 
			{
				a[i].attack();
			}
			System.out.println("ʿ������:"+Soldier.count);
			System.out.println("\n---------------------");
			new Scanner(System.in).nextLine();
		}
		
		
	}
}
