package dd_06_02_�����;

public class Test3 {
	public static void main(String[] args) {
		f(new Point(3,4));
		f(new Point3D(3,4,5));//�������ת�ͳɸ����ʹ��ݵ�f()����
	}
	static void f(Point p) {
		System.out.println(p.toString());
		System.out.println(p.distance());
	}
	
}
