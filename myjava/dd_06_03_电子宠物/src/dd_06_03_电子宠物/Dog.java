package dd_06_03_���ӳ���;

public class Dog {
	String name;//����
	int full;//��ʳ��
	int happy;//���ֶ�
	
	//ιʳ
	public void feed() {
		if(full == 100) {
			System.out.println(name+"�Բ�����");
			return;
		}
		System.out.println("��"+name+"ιʳ");
		full += 10;
		System.out.println("��ʳ�ȣ�"+full);
	}
	//��ˣ
	public void play() {
		if(full == 0) {
			System.out.println(name+"�����治����");
			return;
		}
		System.out.println("��"+name+"��ˣ");
		full -= 10;
		happy += 10;
		System.out.println("��ʳ�ȣ�"+full+"���ֶȣ�"+happy);
	}
	//�ͷ�
	public void punish() {
		System.out.println("��"+name+"��pp"+name+"�޽У���~");
		happy -= 10;
		System.out.println("���ֶȣ�"+happy);
		
	}
}
