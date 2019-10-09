package dd_09_02_字符串;

public class Test1 {
	public static void main(String[] args) {
		char[] a = {'a', 'b', 'c'};
		String s1 = new String(a);//堆内存新分配内存
		String s2 = "abc";//常量池新分配内存
		String s3 = "abc";//访问常量池存在的对象
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s1.equals(s2));
		
		String s5 = new String("abc");
		System.out.println(s5);
	}
}
