package dd_06_01_����;

public class Test1 {
	public static void main(String[] args) {
		//�½�Car����
		//�Ѷ�����ڴ��ַ�����浽����c1
		Car s1 = new Car("����", "��ɫ", 180);
		Car s2 = new Car("����", "��ɫ", 30);
		
		//Ϊc1������������Ը�ֵ ------>���ʹ�ù��췽���±߿���ע�͵�
//		s1.brand = "����";
//		s1.color = "��ɫ";
//		s1.speed = 180;
//		s2.brand = "����";
//		s2.color = "��ɫ";
//		s2.speed = 30;
		//����c1ִ��go()��������stop()����
		s1.go();
		s2.go();
		s1.stop();
		s2.stop();
		
	}
}
