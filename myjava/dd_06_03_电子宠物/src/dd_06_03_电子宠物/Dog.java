package dd_06_03_电子宠物;

public class Dog {
	String name;//名字
	int full;//饱食度
	int happy;//快乐度
	
	//喂食
	public void feed() {
		if(full == 100) {
			System.out.println(name+"吃不下了");
			return;
		}
		System.out.println("给"+name+"喂食");
		full += 10;
		System.out.println("饱食度："+full);
	}
	//玩耍
	public void play() {
		if(full == 0) {
			System.out.println(name+"饿的玩不动了");
			return;
		}
		System.out.println("陪"+name+"玩耍");
		full -= 10;
		happy += 10;
		System.out.println("饱食度："+full+"快乐度："+happy);
	}
	//惩罚
	public void punish() {
		System.out.println("打"+name+"的pp"+name+"哭叫：旺~");
		happy -= 10;
		System.out.println("快乐度："+happy);
		
	}
}
