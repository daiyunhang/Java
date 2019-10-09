package dd_06_01_汽车;

public class Test1 {
	public static void main(String[] args) {
		//新建Car对象
		//把对象的内存地址，保存到变量c1
		Car s1 = new Car("宝马", "红色", 180);
		Car s2 = new Car("奔驰", "绿色", 30);
		
		//为c1对象的三个属性赋值 ------>如果使用构造方法下边可以注释掉
//		s1.brand = "宝马";
//		s1.color = "红色";
//		s1.speed = 180;
//		s2.brand = "奔驰";
//		s2.color = "绿色";
//		s2.speed = 30;
		//控制c1执行go()方法，或stop()方法
		s1.go();
		s2.go();
		s1.stop();
		s2.stop();
		
	}
}
