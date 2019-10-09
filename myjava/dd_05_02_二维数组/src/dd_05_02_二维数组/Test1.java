package dd_05_02_二维数组;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		char[][] a = {
				{'春','眠','不','觉','晓'},
				{'处','处','闻','啼','鸟'},
				{'夜','来','风','雨','声'},
				{'不','知','是','多','少'}
		};
		for(int i=0; i<a[0].length; i++) {
			for(int j=a.length-1; j>=0; j--) {
				System.out.print(a[j][i]);
			}
			System.out.println();
		}
	}
	
}
