package dd_08_04_变形金刚;

public class Transformer {
	/**
	 * 变形金刚使用武器接口
	 * 武器接口定义成变形金刚的成员变量
	 * */
	private Weapon w;
	
	public void setWeapon(Weapon w) {
		this.w = w;
	}
	
	public void attack() {
		if(w == null) {
			System.out.println("用牙咬");
			return;
		}
		
		String s = null;
		switch(w.getType()) {
		case Weapon.TYPE_COLD:s = "冷兵器";break;
		case Weapon.TYPE_HOT:s = "热兵器";break;
		case Weapon.TYPE_MUCLEAR:s = "核武器";break;
		}
		System.out.println(w.getType());
		//使用核武器狼牙棒进攻
		System.out.println("使用"+s+w.genName()+"进攻");
		
		w.kill();
	}
}
