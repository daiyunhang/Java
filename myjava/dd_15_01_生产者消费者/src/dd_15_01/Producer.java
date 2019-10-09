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
			//随机范围a-z ------ 97 + 0 = a   [0,26)
			char c = (char) ('a'+ new Random().nextInt(26));
			synchronized (stack) {
				while(stack.isFull())
				{
					try {
						//在栈对象上等待，
						//收到通知后，会醒过来继续执行
						stack.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				stack.push(c);
				System.out.println("压入<--" + c);
				//通知在栈对象上等待的线程
				stack.notifyAll();
			}
		}
	}
}
