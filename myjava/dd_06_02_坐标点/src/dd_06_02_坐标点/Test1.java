package dd_06_02_�����;

public class Test1 {
	public static void main(String[] args) {
		//�½�����Point����
		//�ڴ��ַ�ֱ𱣴浽����p1��p2
		Point p1 = new Point(3,4);
		Point p2 = new Point();
		
		//Ϊp1��p2��xy���Ը�ֵ
//		p1.x = 3;
//		p1.y = 4;
		p2.x = 5;
		p2.y = 6;
		
		//�ֱ�������������distance()��toString()����������ӡ�����ķ���ֵ
		System.out.println(p1.distance());
		System.out.println(p1.toString());
		System.out.println(p2.distance());
		System.out.println(p2.toString());
		
		
	}
}
