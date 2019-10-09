package dd_06_01_汽车;
/*
 *	封装：
 *		相关的数据和方法代码，
 *		封装在Car类中 
 */
public class Car {
	String brand;
	String color;
	int speed;
	
	//构造方法
	public Car(String brand, String color, int speed) {
		//有同名局部变量
		//必须用this.xxx来访问成员变量
		
		this.speed = speed;
		this.color = color;
		this.brand = brand;
		
	}
	
	public void go() {
		System.out.println(color+brand+"前进，速度"+speed);
	}
	public void stop() {
		System.out.println(color+brand+"停止");
	}
}
