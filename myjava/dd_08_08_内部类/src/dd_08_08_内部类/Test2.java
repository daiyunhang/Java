package dd_08_08_内部类;

public class Test2 {
	public static void main(String[] args) {
		Weapon w1 = f1();
		w1.kill();
		
		Weapon w2 = f2("青龙偃月刀");
		w2.kill();
	}

	private static Weapon f2(String name) {
		Weapon w = new Weapon() {
			
			@Override
			public void kill() {
				System.out.println("使用"+name+"进攻");
			}
		};
		return w;
	}

	private static Weapon f1() {
		class Ak47 implements Weapon {
//			final String name = "Ak47";
			@Override
			public void kill() {
				System.out.println("使用Ak47进攻");
			}
		}
		Ak47 a = new Ak47();
		return a;
	}
}

