package dd_08_04_±äÐÎ½ð¸Õ;

public interface Weapon {
	/*public static final */
	int TYPE_COLD 	 = 0000;
	int TYPE_HOT 	 = 1111;
	int TYPE_MUCLEAR = 2222;
	
	/*public abstract*/ 
	void kill();
	String genName();
	int getType();
	

}
