package dd_08_04_���ν��;

public class Lyb implements Weapon{
	@Override
	public void kill() {
		System.out.println("ˣ��");
	}

	@Override
	public String genName() {
		return "������";
	}

	@Override
	public int getType() {
		return Weapon.TYPE_MUCLEAR;
	}

}
