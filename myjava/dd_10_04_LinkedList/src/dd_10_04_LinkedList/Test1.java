package dd_10_04_LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Test1 {
	public static void main(String[] args) {
		/*
		 * <>泛型
		 * 	 限制集合中存放的数据类型
		 * 
		 * 	 不支持基本类型，要使用包装类型
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
		
		//双向链表，下标遍历效率低
		//每次访问一个下标位置，都从头开始一步一步向后引用
		for(int i=0;i<List.size();i++) {
			String s = List.get(i);
			System.out.println(s);
		}
		System.out.println("-------------------------");
		//迭代器遍历
		//新建迭代器，
		Iterator<String> it = List.iterator();
		//当揩油数据
		while(it.hasNext()) {
			//取下一个数据
			String s = it.next();
			System.out.println(s);
		}
			
		
	}
	
}
