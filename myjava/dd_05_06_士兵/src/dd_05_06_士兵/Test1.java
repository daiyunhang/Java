package dd_05_06_ʿ��;

public class Test1 {
	public static void main(String[] args) {
		//�½�Soldier����
		//�Ѷ�����ڴ��ַ�����浽����s1
		Soldier s1 = new Soldier();
		Soldier s2 = new Soldier();
		
		//�����ñ���s1�ҵ�������ڴ�ռ�
		//����������id����
		s1.id = 9527;
		s2.id = 9528;
		
		//��s1���Ƶ�һ��ʿ��ִ��ǰ������
		s1.go();
		s2.go();
		
		s1.attack();
		s2.attack();
		
		
	}
	
}
