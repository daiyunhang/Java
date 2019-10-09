package dd_08_04_变形金刚;

public class Sword implements Weapon{

	@Override
	public void kill() {
		System.out.println("耍剑");
	}

	@Override
	public String genName() {
		return "倚天剑";
	}

	@Override
	public int getType() {
		return Weapon.TYPE_COLD;
	}

}
