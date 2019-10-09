package dd_15_01;

public class Consumer extends Thread{
	private Stack stack;
	public Consumer(Stack stack) {
		this.stack = stack;
	}
	
	@Override
	public void run() {
		while(true)
		{
			synchronized (stack) {
				while(stack.isEmpty())
				{
					try {
						stack.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				char c = stack.pop();
				System.out.println("弹出-->" + c);
				//发出通知
				stack.notifyAll();
			}
		}
	}
}
