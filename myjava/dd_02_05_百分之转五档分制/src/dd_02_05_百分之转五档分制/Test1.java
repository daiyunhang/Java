package dd_02_05_百分之转五档分制;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		
		System.out.print("输入百分之分数：");
		int s = new Scanner(System.in).nextInt();
		
		if(s<0 || s>100) {
			System.out.println("输入错误 ");
			return;//结束
		}
		
		//把s的值传递到f()方法，求五档分制数，得到方法的返回值存到变量r
		char r = f(s);
		System.out.println(r);
		
	}
	
	static char f(int s) {
		//保存结果变量
		char r = 'A';
		
		//判断s的值
		switch(s/10) {
		case 10:
		case 9:
			r = 'A';
			break;
		case 8:case 7:
			r = 'B';
			break;
		case 6:
			r = 'C';
			break;
		case 5:case 4:case 3:case 2:
			r = 'D';
			break;
		case 1:case 0:
			r = 'E';
		}
		
		return r;
		
	}
	
}
