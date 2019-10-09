package dd_07_03_猜游戏;

import java.util.Random;

public class GuessNumberGame extends GuessGame {

	public String suiji() {
		int r = 1+new Random().nextInt(1000);
		//数字转成字符串返回
		return String.valueOf(r);
	}
	public void tiShi() {
		System.out.println("已经产生了一个[1,1001)范围的随机整数");
		System.out.println("请猜这个数是几");
	}
	public String biJiao(String c, String r) {
		//字符串转成int整数
		
		int cc = Integer.parseInt(c);
		int rr = Integer.parseInt(r);
		
			
		if(cc>rr) {
			return "大";
		}else if(cc<rr) {
			return "小";
		}else {
			return "对";
		}
	}
	public boolean caiDui(String result) {
		return "对".equals(result);
	}
}
