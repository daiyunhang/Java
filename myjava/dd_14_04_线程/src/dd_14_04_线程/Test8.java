package dd_14_04_�߳�;

public class Test8 {
	public static void main(String[] args) {
		R1 r1 = new R1();
		
		//�߳�������,��ѭ��ִ��r1.add()
		Thread t = new Thread(r1);
		
		t.start();
		
		//main�߳�����ѭ������i��ֵ,�Ƿ�������
		R1 r2 = new R1();
		while(true) 
		{
			int i = r2.get();
			if(i%2 == 1) 
			{
				System.out.println(i);
				System.exit(0);//�˳������
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
