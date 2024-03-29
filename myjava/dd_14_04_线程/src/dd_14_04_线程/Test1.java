package dd_14_04_线程;

public class Test1 {
	public static void main(String[] args) {
		/*
		 * 新建两个T1线程对象
		 * 并分别启动,
		 * 线程启动后,自动执行run()方法代码 
		 */
		T1 t1 = new T1();
		T1 t2 = new T1();
		
		t1.start();
		t2.start();
		
		System.out.println("-----------");
		
	}
	
	static class T1 extends Thread {
		@Override
		public void run() {
			//获得线程名
			String n = getName();
			//打印1到100
			for(int i=0;i<=100;i++) {
				System.out.println(n + " - " + i);
			}
		}
	}
	
}
