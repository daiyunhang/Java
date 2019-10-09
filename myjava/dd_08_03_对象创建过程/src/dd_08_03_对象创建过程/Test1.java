package dd_08_03_对象创建过程;

public class Test1 {
	public static void main(String[] args) {
		new B();
		System.out.println("---------");
		new B();
	}
}
class A{
	int v1 = 1;
	static int v2 = 2;
	static {
		System.out.println("A静态块");
	}
	public A() {
		System.out.println("A构造方法");
	}
}
class B extends A{
	int v3 = 3;
	static int v4 = 4;
	static {
		System.out.println("B静态块");
	}
	public B() {
		System.out.println("B构造方法");
	}
}
