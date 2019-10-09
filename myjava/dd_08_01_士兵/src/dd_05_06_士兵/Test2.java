package dd_05_06_士兵;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		//新建Soldier[]数组
		Soldier[] a = new Soldier[5];
		for(int i=0;i<a.length;i++) {
			a[i] = new Soldier();
			a[i].id = i+1;
		}
		//士兵数量不是0，就继续进攻
		while(Soldier.count != 0) 
		{
			for(int i=0;i<a.length;i++) 
			{
				a[i].attack();
			}
			System.out.println("士兵数量:"+Soldier.count);
			System.out.println("\n---------------------");
			new Scanner(System.in).nextLine();
		}
		
		
	}
}
