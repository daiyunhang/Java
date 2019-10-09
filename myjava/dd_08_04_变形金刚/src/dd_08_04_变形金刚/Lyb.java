package dd_08_04_±äÐÎ½ð¸Õ;

public class Lyb implements Weapon{
	@Override
	public void kill() {
		System.out.println("Ë£°ô");
	}

	@Override
	public String genName() {
		return "ÀÇÑÀ°ô";
	}

	@Override
	public int getType() {
		return Weapon.TYPE_MUCLEAR;
	}

}
