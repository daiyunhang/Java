package dd_04_02_双色球;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		//从方法，获得红球号码数组和蓝球号码数组
		int[] r = zbsz(33);
		int[] b = zbsz(16);
		System.out.println(Arrays.toString(r));
		System.out.println(Arrays.toString(b));
		
		//从红球号码数组选择6个，保存到变量red
		int[] red = xuanRed(r);
		//从蓝球号码数组选择1个，保存到变量blue
		int blue = xuanBlue(b);
		System.out.println(Arrays.toString(red));
		System.out.println(blue);
	}
	
	private static int[] xuanRed(int[] r) {
		/**
		 * r
		 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33]
		 * 
		 * red
		 * [      ] length = 6
		 * 
		 * */
		//保存结果的数组
		int[] red = new int[6];
		//标记数组
		boolean[] flag = new boolean[33];
		//遍历red数组，放入选择的红球号
		for(int i=0; i<red.length; i++) {
			//先随机选择一个位置
			//在判断是否要重复再选另一个位置 , 定义一个下标j
			int j;
			do {
				j = new Random().nextInt(33);
				
			} while(flag[j]);
			//选择j位置的值，存入结果数组
			red[i] = r[j];
			flag[j] = true;//标记j位置已经选过
		}
		return red;
	}
	
	private static int xuanBlue(int[] b) {
		return b[new Random().nextInt(16)];
	}

	private static int[] zbsz(int len) {
		/**
		 * 1.新建len长度的int[]数组，保存到变量a
		 * 2.遍历数组，填入1到len
		 * 3.返回数组a
		 **/
		
		int[] a = new int[len];
		for(int i=0; i<a.length; i++) {
			a[i] = i+1;
		}
		return a;
	}
	
	
}
