package dd_06_05_人类;

public class Student extends Person{
	String scholl;
	
	
	/**
	 * 重写toString方法
	 * 从父类中继承的方法
	 * 在子类中重新定义，重新编写
	 * */
	public String toString() {
		String s = super.toString();
		return s+", "+scholl;
	}
	
}
