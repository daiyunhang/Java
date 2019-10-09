package dd_03_04_break和continue;

public class Test2 {

	public static void main(String[] args) {
		//>0.999
				for(int i = 1; i<100; i++){
					int s = i/10;
					if(s==3 || s ==5 || s==7){
						System.out.println("第"+i+"次："+s);
						continue;
					}
				}
				System.out.println("循环结束");

	}

}
