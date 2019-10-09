package dd_11_02_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(555);
		list.add(111);
		list.add(666);
		list.add(222);
		list.add(222);
		list.add(222);
		list.add(333);
		list.add(999);
		list.add(333);
		list.add(888);
		list.add(222);
		list.add(222);
		list.add(222);
		list.add(222);
		list.add(222);
		list.add(222);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.remove(3));
		System.out.println(list);
		System.out.println(list.remove(Integer.valueOf(222)));
		System.out.println(list);
		
		
		//下标遍历
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-------------------------");
		//迭代器遍历
		Iterator<Integer> it = list.iterator();
		//当揩油数据
		while(it.hasNext()) {
			//取下一个数据
			Integer i = it.next();
			System.out.println(i);
			if(i == 222) {
				//迭代遍历期间，不能使用集合
				//来添加或删除数据
//				list.add(0, 5534);
				it.remove();
			}
		}
		System.out.println("--------------------");
		System.out.println(list);
		
		
		
		
		
		
	}
	
}
