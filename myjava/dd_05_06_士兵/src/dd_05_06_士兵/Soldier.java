package dd_05_06_ʿ��;

import java.util.Random;
/*
 *	��װ
 *		��ʿ����ص��������ݡ��������룬
 *		��װ��һ�����������(��) 
 */
public class Soldier {
	//�������ݣ���Ա����
	int id;//Ĭ��0
	int blood = 100; 
	
	//���췽��
	public Soldier() {
		System.out.println("�½�Soldier����ʱִ��");
	}
	
	//��Ա����
	public void go(){
		System.out.println(id+"��ʿ��ǰ��");
	}
	public void attack(){
		if(blood == 0){
			System.out.println("����"+id+"��ʿ����ʬ��");
			return;
		}
		System.out.println(id+"��ʿ������");
		//��������ļ�Ѫ��
		int d = new Random().nextInt(10);//����ļ�Ѫ��
		blood -= d;
		//���Ѫ����ɸ������ó�0
		if(blood<0) blood=0;
		System.out.println("Ѫ����"+blood);
		if(blood == 0){
			System.out.println(id+"��ʿ������");
		}
	}
	
	
}
