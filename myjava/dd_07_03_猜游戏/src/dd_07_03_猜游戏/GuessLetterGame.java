package dd_07_03_����Ϸ;

import java.util.Random;

public class GuessLetterGame extends GuessGame{

	public String suiji() {
		StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		for(int i=0; i<5; i++) {
			int j = new Random().nextInt(26);
			char t = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, t);
		}
		String s = sb.substring(0,5);
		System.out.println(s);
		return s;
	}
	public void tiShi() {
		
		System.out.println("�Ѿ�����5�����ظ��Ĵ�д��ĸ");
		System.out.println("��²�5����ĸ");
	}
	public String biJiao(String c, String r) {
		int a = 0;
		int b = 0;
		for(int i=0; i<c.length(); i++) {
			for(int j=0; j<r.length(); j++) {
				//iλ���ַ���jλ���ַ����
				if(c.charAt(i) == r.charAt(j)) {
					if(i==j) {//λ�����
						a++;
					}else {
						b++;//λ�ò����
					}
					//jλ���ҵ���ͬ�ַ��������������
					break;
				}
			}
		}
		return a+"A"+b+"B";
	}
	
	public boolean caiDui(String result) {
		return "5A0B".equals(result);
	}
}
