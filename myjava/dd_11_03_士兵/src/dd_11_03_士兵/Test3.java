package dd_11_03_ʿ��;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.print("����ʿ������:");
		int n = new Scanner(System.in).nextInt();
		
		ArrayList<Soldier> list = new ArrayList<>(n);
		for(int i=0;i<=n;i++) {
			Soldier s = new Soldier();
			s.id = i+1;
			list.add(s);
		}
//		while(Soldier.count != 0) {  //���ַ�ʽ�ж�
		while(list.size() != 0) {
			new Scanner(System.in).nextLine();
			for(Iterator<Soldier> it = list.iterator();it.hasNext();) {
				Soldier s = it.next();
				s.attack();
				if(s.blood == 0) {
					it.remove();
				}
			}
			System.out.println("ʿ������"+list.size());
			System.out.println("------------------");
		}
	}
	
}
