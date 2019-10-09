package dd_06_02_坐标点;

public class Test1 {
	public static void main(String[] args) {
		//新建两个Point对象
		//内存地址分别保存到变量p1和p2
		Point p1 = new Point(3,4);
		Point p2 = new Point();
		
		//为p1，p2的xy属性赋值
//		p1.x = 3;
//		p1.y = 4;
		p2.x = 5;
		p2.y = 6;
		
		//分别调用两个对象的distance()和toString()方法，并打印方法的返回值
		System.out.println(p1.distance());
		System.out.println(p1.toString());
		System.out.println(p2.distance());
		System.out.println(p2.toString());
		
		
	}
}
