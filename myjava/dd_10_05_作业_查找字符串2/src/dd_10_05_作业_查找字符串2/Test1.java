package dd_10_05_作业_查找字符串2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入字符串:");
		String s = new Scanner(System.in).nextLine();
		System.out.println("查找的字串:");
		String t = new Scanner(System.in).nextLine();
		
		LinkedList<Integer> a = find(s,t);
		System.out.println(a);
	}

	private static LinkedList<Integer> find(String s, String t) {
		/*
		 * aaaaaaaaaaaaaaaa
		 * a
		 * 
		 * [1,4,7,
		 */
		//创建足够长的数组
		LinkedList<Integer> list = new LinkedList<>();
		
		//用来标记从哪开始向后找
		//并保存找到的下标位置
		int index = 0;
		
		//死循环向后找
		while(true) {
			//从index向后找
			index = s.indexOf(t, index);
			if(index == -1) {
				break;
			}
			list.add(index);
			index++;
			if(index >= s.length()) {
				break;
			}
		}
		return list;
	}
}
