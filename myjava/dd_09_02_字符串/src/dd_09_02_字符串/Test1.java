package dd_09_02_�ַ���;

public class Test1 {
	public static void main(String[] args) {
		char[] a = {'a', 'b', 'c'};
		String s1 = new String(a);//���ڴ��·����ڴ�
		String s2 = "abc";//�������·����ڴ�
		String s3 = "abc";//���ʳ����ش��ڵĶ���
		
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
