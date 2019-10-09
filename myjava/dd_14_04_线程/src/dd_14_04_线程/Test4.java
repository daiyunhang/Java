package dd_14_04_线程;

public class Test4 {
	public static void main(String[] args) throws InterruptedException {
		/*
		 ** 求10000000内的质数数量 
		 */
		
		long t;
		int r;
		t = System.currentTimeMillis();
		r = f1();
		System.out.println("质数数量:"+r);
		System.out.println(
				System.currentTimeMillis()-t);
		
		t = System.currentTimeMillis();
		r = f2();//5个线程
		System.out.println("质数数量:"+r);
		System.out.println(
				System.currentTimeMillis()-t);
		
		
	}

	private static int f2() throws InterruptedException {
		T1 t1 = new T1(1,2000000);
		T1 t2 = new T1(2000000,4000000);
		T1 t3 = new T1(4000000,6000000);
		T1 t4 = new T1(6000000,8000000);
		T1 t5 = new T1(8000000,10000000);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		int r = t1.count+t2.count+t3.count+t4.count+t5.count;
		return r;
	}

	private static int f1() throws InterruptedException {
		T1 t1 = new T1(1,10000000);
		t1.start();
		t1.join();//main等待t1线程执行结束
		return t1.count;
	}

	static class T1 extends Thread{
		int start;
		int end;
		int count;//计数值
		public T1(int start, int end) {
			if(start<3) {
				start = 3;
				count = 1;
			}
			this.start = start;
			this.end = end;
		}
		
		@Override
		public void run() {
			for(int i=start;i<end;i++) {
				if(prime(i)) {//如果i是质数
					count++;
				}
			}
		}

		//判断i的值是否是质数
		private boolean prime(int i) {
			double max = Math.sqrt(i)+1;
			for(int j=2;j<max;j++) {
				if(i%j == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
