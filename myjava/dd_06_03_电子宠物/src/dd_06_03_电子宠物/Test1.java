package dd_06_03_���ӳ���;

import java.util.Scanner;

import javax.crypto.Mac;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("������������֣�");
		String name = new Scanner(System.in).nextLine();
		
		//�½�Dog���󣬵�ַ���浽����dog
		Dog dog = new Dog();
		
		//Ϊdog���������Ը�ֵ
		dog.name = name;
		dog.full = 50;
		dog.happy = 50;
		
		while(true) {
			double d = Math.random();
			if(d < 0.33) {
				dog.feed();
			}else if(d < 0.66) {
				dog.play();
			}else {
				dog.punish();
			}
			//�ȴ��û����س�����
			new Scanner(System.in).nextLine();
		}
		
		
	}
}
