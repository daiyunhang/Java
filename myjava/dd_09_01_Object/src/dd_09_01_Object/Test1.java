package dd_09_01_Object;

public class Test1 {
	public static void main(String[] args) {
		Point b = new Point(3, 4);
		Point a = new Point(3, 4);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(a == b);
		System.out.println(a.equals(b));
		
	}
}
