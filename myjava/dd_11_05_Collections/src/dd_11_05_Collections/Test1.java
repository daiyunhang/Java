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
		 * * sort()����������ʹ��һ���Ƚ�������
		 * * �������ݴ�С���бȽ�
		 */
		Collections.sort(list, new Comparator<String>() {
			/*
			 * o1��o2�ȴ�С
			 * o1������
			 * o2�󣬸���
			 * *��ͬ 0
			 */
			@Override
			public int compare(String o1, String o2) {
				//�ַ���ת��int
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
