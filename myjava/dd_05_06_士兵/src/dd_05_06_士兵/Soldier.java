package dd_05_06_士兵;

import java.util.Random;
/*
 *	封装
 *		把士兵相关的属性数据、方法代码，
 *		封装成一个独立的组件(类) 
 */
public class Soldier {
	//属性数据，成员变量
	int id;//默认0
	int blood = 100; 
	
	//构造方法
	public Soldier() {
		System.out.println("新建Soldier对象时执行");
	}
	
	//成员方法
	public void go(){
		System.out.println(id+"号士兵前进");
	}
	public void attack(){
		if(blood == 0){
			System.out.println("这是"+id+"号士兵的尸体");
			return;
		}
		System.out.println(id+"号士兵进攻");
		//定义随机的减血量
		int d = new Random().nextInt(10);//随机的减血量
		blood -= d;
		//如果血量变成负数，置成0
		if(blood<0) blood=0;
		System.out.println("血量："+blood);
		if(blood == 0){
			System.out.println(id+"号士兵阵亡");
		}
	}
	
	
}
