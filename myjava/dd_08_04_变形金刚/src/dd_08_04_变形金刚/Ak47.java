package dd_08_04_±äÐÎ½ð¸Õ;

public class Ak47 implements Weapon{

	@Override
	public void kill() {
		System.out.println("Ë£Ç¹");
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
