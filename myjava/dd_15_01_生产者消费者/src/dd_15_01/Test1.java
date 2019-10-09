package dd_15_01;

public class Test1 {
	public static void main(String[] args) {
		Stack stack = new Stack();
		Producer p = new Producer(stack);
		Consumer c = new Consumer(stack);
		p.start();
		c.start();
		
		
		while(true)
		{
			synchronized(stack){
				stack.notifyAll();
			}
		}
	}
}
