package dd_09_02_字符串;

public class Test2 {
	public static void main(String[] args) {
		String s0 = "abcdefghijklmnopqrstuvwsyz";
		String s = "";
		
		/*
		 *  获得系统时间毫秒值
		 *  从1970年1月1号0点开始的毫秒值
		  */
		long t = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			s += s0;
		}
		t = System.currentTimeMillis()-t;
		System.out.println(t);
	}
}
