package dd_12_01;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		System.out.print("�û�����");
		String n = new Scanner(System.in).nextLine();
		System.out.print("���룺");
		String p = new Scanner(System.in).nextLine();
		try {
		login(n,p);
		System.out.println("��ӭ��½");
		} catch (UsernameNotFoundException e) {
			System.out.println("�û�������ȷ");
		} catch(WrongPasswordException e) {
			System.out.println("���벻��ȷ");
		}
	}

	private static void login(String n, String p) throws UsernameNotFoundException,WrongPasswordException{
		//abc 123
		if(!n.equals("abc")) {
			throw new UsernameNotFoundException();
		}
		if(!p.equals("123")) {
			throw new WrongPasswordException();
		}
	}
}
