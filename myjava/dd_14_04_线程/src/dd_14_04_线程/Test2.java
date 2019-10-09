package dd_14_04_线程;

public class Test2 {
	public static void main(String[] args) {
		//封装代码的对象
		R1 r1 = new R1();
		//代码交给线程
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		//两个线程启动后,
		//都执行 r1.run()
		t1.start();
		t2.start();
		
		Thread t = Thread.currentThread();
		String s = t.getName();
		System.out.println(s);
	}

	/*
	 * 用来封装代码
	 * run()方法代码要放入线程执行
	 */
	static class R1 implements Runnable{
		@Override
		public void run() {
			//获得正在执行的线程对象
			Thread t = Thread.currentThread();
			
			String n = t.getName();
			//打印1到100
			for(int i=0;i<=100;i++) {
				System.out.println(n + " - " + i);
			
		}
	}
	}
}
