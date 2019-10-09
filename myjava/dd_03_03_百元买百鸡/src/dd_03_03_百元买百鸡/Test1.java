package dd_03_03_百元买百鸡;

public class Test1 {

	public static void main(String[] args) {
		
	/**
	 *  公鸡5元1只
	 *  母鸡3元1只
	 *  小鸡1元3只
	 *  
	 *  穷举100元可以买的所有组合，找到100只的组合
	 *  
	 *  g m x 
	 *  0 0 300
	 *  0 1 291
	 *  0 2 282
	 *  ..
	 *  0 25 75 //=>100
	 *  0 33 3
	 *  
	 *  1 0 285
	 *  1 1 276 
	 *  1 2 267
	 *  ...
	 *  1 31 6
	 *  2 0  xxx
	 *  2 1  xxx
	 *  ...
	 *  
	 * */
		
			
		/***
		 * 1.g循环从0 到 <=20递增 
		 * 	  2.买g只公鸡剩的钱，存到变量money
		 *    3.money最多能买多少只，存到变量max
		 *    4.m循环从0<=max递增
		 *    	5.又买m只母鸡剩的钱能买多小鸡，小鸡数量存到变量x
		 *      6.如果 g+m+x == 100
		 *         7.打印组合
		 */
		
		for(int g=0; g<=20; g++){
			int money = 100-g*5;
			int max = money/3;
			for(int m=0; m<=max; m++){
				int x = (money - m*3) * 3;
				if(g+m+x == 100){
					System.out.println(g+","+m+","+x);
				}
			}
		}
		
		
	}

}
