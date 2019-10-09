package dd_11_04_HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.print("输入字符串:");
		String s = new Scanner(System.in).nextLine();
		
		/*
		 * 1.新建HashMap<Character, Integer> map
		 * 2.i循环遍历字符串
		 * 		3.取出字符串s中i位置的字符c
		 * 		4.从map取字符c的计数值保存到变量count
		 * 		5.如果count == null
		 * 			6.放入字符c和计数1
		 * 		7.否则
		 * 			8.放入字符c和计数count+1
		 * 	9.打印map
		 */
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			//取出的可能是null，要用引用类型
			Integer count = map.get(c);
			if(count == null) {
				map.put(c, 1);
			}else {
				map.put(c, count+1);
			}
		}
		System.out.println(map);
	}
	
}
