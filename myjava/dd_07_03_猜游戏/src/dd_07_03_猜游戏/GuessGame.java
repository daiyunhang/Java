package dd_07_03_����Ϸ;

import java.util.Scanner;

public abstract class GuessGame {
	/**
	 * �����ֺͲ���ĸ������Ϸ��ͨ������
	 * */
	public void start() {
		//�������ֵ
		String r = suiji();
		//��ʾ��ʾ
		tiShi();
		//��ѭ��
		while(true) {
			System.out.print("�£�");
			String c = new Scanner(System.in).nextLine();
			//�Ƚ�c��r�����õ��ȽϽ��
			if(c.isEmpty()) 
			{
				System.out.println("���������벻��Ϊ��");
				break;
			}else 
			{
				String result = biJiao(c,r);
				System.out.println(result);
				//�ж��Ƿ��ǲŶԵĽ��
				if(caiDui(result)) {
					break;
				}
			}
		}
	}
	public abstract String suiji();
	public abstract void tiShi();
	public abstract String biJiao(String c, String r);
	public abstract boolean caiDui(String result);
	
}
