package dd_09_03_StringBuilder;

public class Test1 {
	public static void main(String[] args) {
		String s0 = "abcdefghijklmnopqrstuvwsyz";
		StringBuilder sb = new StringBuilder();
		long t = System.currentTimeMillis();

		for(int i=0; i<10000000; i++) {
			sb.append(s0);
		}
		
		t = System.currentTimeMillis()-t;
		System.out.println(t);
//		System.out.println(sb);
	}
}
