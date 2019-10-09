package dd_06_02_坐标点;

public class Test3 {
	public static void main(String[] args) {
		f(new Point(3,4));
		f(new Point3D(3,4,5));//子类对象，转型成父类型传递到f()方法
	}
	static void f(Point p) {
		System.out.println(p.toString());
		System.out.println(p.distance());
	}
	
}
