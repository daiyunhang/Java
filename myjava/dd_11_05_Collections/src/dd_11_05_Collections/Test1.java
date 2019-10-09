package dd_11_05_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list, 
				"1",
				"22",
				"3",
				"44",
				"55",
				"6",
				"87",
				"234",
				"21"
				);
		System.out.println(list);//[1, 22, 3, 44, 55, 6, 87, 234, 21]
		Collections.sort(list);
		System.out.println(list);//[1, 21, 22, 234, 3, 44, 55, 6, 87]
		/*
		 * * sort()方法，可以使用一个比较器对象
		 * * 来对数据大小进行比较
		 */
		Collections.sort(list, new Comparator<String>() {
			/*
			 * o1和o2比大小
			 * o1大，正数
			 * o2大，负数
			 * *相同 0
			 */
			@Override
			public int compare(String o1, String o2) {
				//字符串转成int
				int a = Integer.parseInt(o1);
				int b = Integer.parseInt(o2);
//				return a-b;
				if(a<b) {
					return -1;
				}else if(a>b) {
					return 1;
				}else {
					return 0;
				}
			}
			
		});
		System.out.println(list);
		
		// for-each
		for (String s : list) {
			System.out.println(s);
		}
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String s = (String) iterator.next();
			System.out.println(s);
		}
	}
}
