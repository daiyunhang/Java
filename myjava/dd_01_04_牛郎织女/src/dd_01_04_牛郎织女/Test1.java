package dd_01_04_ţ��֯Ů;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("ţ��֯Ů�����16.4����");
		System.out.println("���� 299792458��/��");
		System.out.println("ϲȵ�쳤0.46��");
		System.out.println("ţ��֯Ů��ᣬ��Ҫ����ֻϲȵ");
		
		
		//һ�����Ƕ�����
		long ly = 299792458L*60*60*24*365;
		
		//16.4����Ķ�����
		double d = 16.4 * ly;
		
		//ϲȵ������
		double r = d/0.46;
		
		//��r����ȡ��
		//Math.ceil(r);
		long n = (long) Math.ceil(r);
		System.out.println(n);
		System.out.println("------------------------------");
		
		
		System.out.println(1+2+"abc");
		
	}
	
	
}
