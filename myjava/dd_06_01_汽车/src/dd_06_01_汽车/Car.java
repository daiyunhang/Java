package dd_06_01_����;
/*
 *	��װ��
 *		��ص����ݺͷ������룬
 *		��װ��Car���� 
 */
public class Car {
	String brand;
	String color;
	int speed;
	
	//���췽��
	public Car(String brand, String color, int speed) {
		//��ͬ���ֲ�����
		//������this.xxx�����ʳ�Ա����
		
		this.speed = speed;
		this.color = color;
		this.brand = brand;
		
	}
	
	public void go() {
		System.out.println(color+brand+"ǰ�����ٶ�"+speed);
	}
	public void stop() {
		System.out.println(color+brand+"ֹͣ");
	}
}
