package dd_10_04_LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Test2 {
	public static void main(String[] args) {
		//准备集合
		LinkedList<String> list = new LinkedList<>();
		for(int i=0;i<100000;i++) {
			list.add("a");
		}
		System.out.println(list.size());
		
		System.out.println("----下标遍历---------------");
		long t = System.currentTimeMillis();
		f1(list);
		t = System.currentTimeMillis()-t;
		System.out.println(t);
		
		System.out.println("----迭代遍历---------------");
		t = System.currentTimeMillis();
		f2(list);
		t = System.currentTimeMillis()-t;
		System.out.println(t);
	}

	private static void f1(LinkedList<String> list) {
		for(int i=0;i<list.size();i++) {
			list.get(i);
		}
		
	}

	private static void f2(LinkedList<String> list) {
		//新建迭代器对象
		Iterator<String> it = list.iterator();
		//当还有数据
		while(it.hasNext()) {
			it.next();
		}
		
	}
	
	
}
