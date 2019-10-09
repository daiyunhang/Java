package dd_07_03_猜游戏;

import java.util.Scanner;

public abstract class GuessGame {
	/**
	 * 猜数字和猜字母两种游戏的通用流程
	 * */
	public void start() {
		//产生随机值
		String r = suiji();
		//显示提示
		tiShi();
		//死循环
		while(true) {
			System.out.print("猜：");
			String c = new Scanner(System.in).nextLine();
			//比较c和r，并得到比较结果
			if(c.isEmpty()) 
			{
				System.out.println("请重新输入不能为空");
				break;
			}else 
			{
				String result = biJiao(c,r);
				System.out.println(result);
				//判断是否是才对的结果
				if(caiDui(result)) {
					break;
				}
			}
		}
	}
	public abstract String suiji();
	public abstract void tiShi();
	public abstract String biJiao(String c, String r);
	public abstract boolean caiDui(String result);
	
}
