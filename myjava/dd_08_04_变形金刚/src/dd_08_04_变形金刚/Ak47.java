package dd_08_04_���ν��;

public class Ak47 implements Weapon{

	@Override
	public void kill() {
		System.out.println("ˣǹ");
	}

	@Override
	public String genName() {
		return "AK47";
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return Weapon.TYPE_HOT;
	}

}
