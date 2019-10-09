package dd_14_04_Ïß³Ì;

import java.util.Arrays;

public class Test5 {
	public static void main(String[] args) {
		char[] a = {'-','-','-','-','-'};
	
		System.out.println(a );
		
		new Thread() {
			public void run() {
				while(true) 
				{
					synchronized (a) {
						for (int i = 0; i < a.length; i++) {
							a[i] = a[i] == '-' ? '*' : '-';
						}
					}
				}
			};
		}.start();
		
		new Thread() {
			public void run() {
				while(true)
				{
					synchronized (a) {
						System.out.println(Arrays.toString(a));
					}
				}
			};
		}.start();
	}
	
	
}
