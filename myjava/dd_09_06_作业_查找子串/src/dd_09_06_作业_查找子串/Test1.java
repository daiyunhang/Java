package dd_09_06_作业_查找子串;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入字符串:");
		String s = new Scanner(System.in).nextLine();
		System.out.println("查找的字串:");
		String t = new Scanner(System.in).nextLine();
		
		int[] a = find(s,t);
		System.out.println(Arrays.toString(a));
	}

	private static int[] find(String s, String t) {
		/*
		 * aaaaaaaaaaaaaaaa
		 * a
		 * 
		 * [1,4,7,
		 */
		//创建足够长的数组
		int[] a = new int[s.length()];
		int i = 0; //用来访问数组a
		
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
			a[i] = index;
			i++;
			index++;
			if(index >= s.length()) {
				break;
			}
		}
		return Arrays.copyOf(a, i);
	}
}
