package dd_10_04_LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Test1 {
	public static void main(String[] args) {
		/*
		 * <>����
		 * 	 ���Ƽ����д�ŵ���������
		 * 
		 * 	 ��֧�ֻ������ͣ�Ҫʹ�ð�װ����
		 * 
		 */
		
		LinkedList<String> List = new LinkedList<>();
		List.add("aaa");
		List.add("bbb");
		List.add("ccc");
		List.add("ddd");
		List.add("eee");
		List.add("rrr");
		List.add("sss");
		List.add("ggg");
		List.add("aaa");
		List.add("aaa");
		System.out.println(List);
		System.out.println(List.size());
		System.out.println(List.get(0));
		System.out.println(List.get(List.size()-1));
		System.out.println(List.remove(3));
		System.out.println(List);
		
		//˫�������±����Ч�ʵ�
		//ÿ�η���һ���±�λ�ã�����ͷ��ʼһ��һ���������
		for(int i=0;i<List.size();i++) {
			String s = List.get(i);
			System.out.println(s);
		}
		System.out.println("-------------------------");
		//����������
		//�½���������
		Iterator<String> it = List.iterator();
		//����������
		while(it.hasNext()) {
			//ȡ��һ������
			String s = it.next();
			System.out.println(s);
		}
			
		
	}
	
}
