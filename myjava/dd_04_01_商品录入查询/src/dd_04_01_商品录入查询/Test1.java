package dd_04_01_商品录入查询;

import java.util.Scanner;

public class Test1 {
	static String[] names = {"iPhone X","小米8","华为P20","voio NEX","oppo FIND X"};//商品名字
	static double[] price = {7200, 2800, 4699, 2099, 2300};//价格
	static int[] numbers = {200, 500, 600, 200, 100};//数量
	
	public static void main(String[] args) {
		outer:
		while(true) {
			//显示菜单
			showMenu();
			//获取选择的值
			int c = new Scanner(System.in).nextInt();
			switch(c) {
			case 1: f1();break;
			case 2: f2();break;
			case 3: f3();break;
			case 4: f4();break;
			case 5: break outer;
			}
		}
		
	}

	private static void showMenu() {
		System.out.println("----------------");
		System.out.println("1.商品列表");
		System.out.println("2.商品录入");
		System.out.println("3.商品查询");
		System.out.println("4.统计信息");
		System.out.println("5.退出");
		System.out.println("----------------");
		System.out.print("选择：");
	}
	
	private static void f1() {
		//遍历数组
		for(int i=0; i<names.length; i++) {
			System.out.println((i+1)+". 名称："+names[i]+" 价格："+price[i]+" 数量："+numbers[i]+" 总价："+ (price[i]*numbers[i]));
		}
	}

	private static void f2() {
		//遍历数组
		for(int i=0; i<names.length; i++) {
			System.out.print("--第"+(i+1)+"件商品-----------------");
			System.out.print("名称：");
			String n = new Scanner(System.in).nextLine();
			System.err.print("价格：");
			double p = new Scanner(System.in).nextDouble();
			System.err.print("数量：");
			int r = new Scanner(System.in).nextInt();
			//录入的商品数据，存入数组
			names[i] = n;
			price[i] = p;
			numbers[i] = r;
		}
		//调用f1方法，重新显示商品列表
		f1();
	}

	private static void f3() {
		//输入查询商品名称
		System.out.print("商品名称：");
		String s = new Scanner(System.in).nextLine();
		//遍历
		for(int i=0; i<names.length; i++) {
			//找相同名称
			//字符串相等比较，调用equale()方法
			if(s.equals(names[i])) {
				System.out.println((i+1)+". 名称："+names[i]+" 价格："+price[i]+" 数量："+numbers[i]+" 总价："+ (price[i]*numbers[i]));
				return; //方法结束
			}
		}
		System.out.println("没有找到商品");
	}

	private static void f4() {
		
		/**
		 * 货物总价
		 * 单价均价
		 * 最高单价
		 * 最高总价
		 * */
		double hwzj = 0;//货物总价
		double djzj = 0;//单价总价
		double zgdj = 0;//最高单价
		double zgzj = 0;//最高总价
		
		//遍历数组
		for(int i=0; i<names.length; i++) {
			hwzj += price[i]*numbers[i];
			djzj += price[i];
			//判断 如果单价比zgdj高
			if(price[i] > zgdj) {
				zgdj = price[i];
			}
			if(price[i]*numbers[i] > zgzj) {
				zgzj = price[i]*numbers[i];
			}
		}
		System.out.println("货物总价："+hwzj);
		System.out.println("单价均价："+(djzj/names.length));
		System.out.println("最高单价："+zgdj);
		System.out.println("最高总价："+zgzj);
		
		
	}
	
	
}
