package dd_08_04_���ν��;

import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Sword s = new Sword();
		Ak47 a = new Ak47();
		Lyb l = new Lyb();
		Transformer t = new Transformer();
		
		t.attack();
		
		while(true) {
			new Scanner(System.in).nextLine();
			int r = new Random().nextInt(4);
			switch(r) {
			case 0: t.setWeapon(s);break;
			case 1: t.setWeapon(a);break;
			case 2: t.setWeapon(l);break;
			case 3: t.setWeapon(new Weapon() {
				public void kill() {
					System.out.println("�����ؿ�");
				}
				public String genName() {
					return "Сȭȭ";
				}
				public int getType() {
					return Weapon.TYPE_HOT;
				}
				
			});break;
			}
			t.attack();
		}
	}
	
	
}
