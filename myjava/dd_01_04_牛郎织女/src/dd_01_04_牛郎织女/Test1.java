package dd_01_04_牛郎织女;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("牛郎织女星相距16.4光年");
		System.out.println("光速 299792458米/秒");
		System.out.println("喜鹊伸长0.46米");
		System.out.println("牛郎织女相会，需要多少只喜鹊");
		
		
		//一光年是多少米
		long ly = 299792458L*60*60*24*365;
		
		//16.4光年的多少米
		double d = 16.4 * ly;
		
		//喜鹊的数量
		double r = d/0.46;
		
		//对r向上取整
		//Math.ceil(r);
		long n = (long) Math.ceil(r);
		System.out.println(n);
		System.out.println("------------------------------");
		
		
		System.out.println(1+2+"abc");
		
	}
	
	
}
