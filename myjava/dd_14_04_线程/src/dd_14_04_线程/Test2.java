package dd_14_04_�߳�;

public class Test2 {
	public static void main(String[] args) {
		//��װ����Ķ���
		R1 r1 = new R1();
		//���뽻���߳�
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		//�����߳�������,
		//��ִ�� r1.run()
		t1.start();
		t2.start();
		
		Thread t = Thread.currentThread();
		String s = t.getName();
		System.out.println(s);
	}

	/*
	 * ������װ����
	 * run()��������Ҫ�����߳�ִ��
	 */
	static class R1 implements Runnable{
		@Override
		public void run() {
			//�������ִ�е��̶߳���
			Thread t = Thread.currentThread();
			
			String n = t.getName();
			//��ӡ1��100
			for(int i=0;i<=100;i++) {
				System.out.println(n + " - " + i);
			
		}
	}
	}
}
