package dd_03_04_break��continue;

public class Test2 {

	public static void main(String[] args) {
		//>0.999
				for(int i = 1; i<100; i++){
					int s = i/10;
					if(s==3 || s ==5 || s==7){
						System.out.println("��"+i+"�Σ�"+s);
						continue;
					}
				}
				System.out.println("ѭ������");

	}

}
