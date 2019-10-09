package dd_07_03_猜游戏;

import java.util.Random;

public class GuessLetterGame extends GuessGame{

	public String suiji() {
		StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		for(int i=0; i<5; i++) {
			int j = new Random().nextInt(26);
			char t = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, t);
		}
		String s = sb.substring(0,5);
		System.out.println(s);
		return s;
	}
	public void tiShi() {
		
		System.out.println("已经产生5个不重复的大写字母");
		System.out.println("请猜猜5个字母");
	}
	public String biJiao(String c, String r) {
		int a = 0;
		int b = 0;
		for(int i=0; i<c.length(); i++) {
			for(int j=0; j<r.length(); j++) {
				//i位置字符和j位置字符相等
				if(c.charAt(i) == r.charAt(j)) {
					if(i==j) {//位置相等
						a++;
					}else {
						b++;//位置不相等
					}
					//j位置找到相同字符，不必在向后找
					break;
				}
			}
		}
		return a+"A"+b+"B";
	}
	
	public boolean caiDui(String result) {
		return "5A0B".equals(result);
	}
}
