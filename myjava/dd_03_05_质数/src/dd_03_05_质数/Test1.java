package dd_03_05_����;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		System.out.print("��������n����n��������������");
		int n = new Scanner(System.in).nextInt();
		
		//n���ݵ�prime()����������������
		int r = prime(n);
		System.out.println(r);
	}

	private static int prime(int n) {
		
		if(n < 2) {
			return 0;	
		}
		
		//��������
		int c = 0;
		
		//2��n��Χ�ڣ�������
		outer:
		for(int i=2; i<=n; i++) {
			//iʱ��������
			//2��<����i+1��Χ�ڣ��ҵ��ܰ�i������ֵ
			
			double max = Math.sqrt(i) + 1;
			for(int j=2; j<max; j++) {
				//i�ܱ�j����
				if(i%j == 0) {
					//i��������,����i++,�ж���һ��iֵ�Ƿ�������
					continue outer;
				}
			}
			//i����������������
			c++;
		}
		return c;
	}
	
	

	
	
	

}
