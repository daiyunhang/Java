package dd_14_04_�߳�;

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
						//sleep(����) ��ͣ 1s  
						Thread.sleep(1000);
					} catch (InterruptedException e) {
//						e.printStackTrace();
						System.out.println("˭TMDͱ��������");
						break;
					}
				}
				
			}
		};
		t.start();
		
		System.out.println("���س�");
		new Scanner(System.in).nextLine();
		//���t�̵߳���ͣ״̬
		t.interrupt();
		
		
		
		
	}
	
	
}
