package dd_08_04_���ν��;

public class Sword implements Weapon{

	@Override
	public void kill() {
		System.out.println("ˣ��");
	}

	@Override
	public String genName() {
		return "���콣";
	}

	@Override
	public int getType() {
		return Weapon.TYPE_COLD;
	}

}
