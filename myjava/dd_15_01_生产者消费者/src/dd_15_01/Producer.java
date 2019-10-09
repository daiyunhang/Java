package dd_15_01;

import java.util.Random;

public class Producer extends Thread{
	private Stack stack;
		
	public Producer(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		while(true)
		{
			//�����Χa-z ------ 97 + 0 = a   [0,26)
			char c = (char) ('a'+ new Random().nextInt(26));
			synchronized (stack) {
				while(stack.isFull())
				{
					try {
						//��ջ�����ϵȴ���
						//�յ�֪ͨ�󣬻��ѹ�������ִ��
						stack.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				stack.push(c);
				System.out.println("ѹ��<--" + c);
				//֪ͨ��ջ�����ϵȴ����߳�
				stack.notifyAll();
			}
		}
	}
}
