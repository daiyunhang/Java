package dd_14_04_线程;

public class Test8 {
	public static void main(String[] args) {
		R1 r1 = new R1();
		
		//线程启动后,死循环执行r1.add()
		Thread t = new Thread(r1);
		
		t.start();
		
		//main线程中死循环访问i的值,是否是奇数
		R1 r2 = new R1();
		while(true) 
		{
			int i = r2.get();
			if(i%2 == 1) 
			{
				System.out.println(i);
				System.exit(0);//退出虚拟机
			}
		}
		
	}
	
	static class R1 implements Runnable {
		static int i;
		
		public static synchronized void add() {
			i++;
			i++;
		}
		
		public static synchronized int get() {
			return i;
		}
		
		@Override
		public void run() {
			while(true) 
			{
				add();
			}
		}
	}
	
}
