package dd_14_04_线程;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Thread t = new Thread() 
		{
			@Override
			public void run() {
				SimpleDateFormat sdf =
				new SimpleDateFormat("HH:mm:ss");
				
				while(true) {
					String s = sdf.format(new Date());
					System.out.println(s);
					try {
						//sleep(毫秒) 暂停 1s  
						Thread.sleep(1000);
					} catch (InterruptedException e) {
//						e.printStackTrace();
						System.out.println("谁TMD捅行了老子");
						break;
					}
				}
				
			}
		};
		t.start();
		
		System.out.println("按回车");
		new Scanner(System.in).nextLine();
		//打断t线程的暂停状态
		t.interrupt();
		
		
		
		
	}
	
	
}
