package dd_05_06_士兵;

public class Test1 {
	public static void main(String[] args) {
		//新建Soldier对象
		//把对象的内存地址，保存到变量s1
		Soldier s1 = new Soldier();
		Soldier s2 = new Soldier();
		
		//用引用变量s1找到对象的内存空间
		//并访问它的id变量
		s1.id = 9527;
		s2.id = 9528;
		
		//用s1控制第一个士兵执行前进方法
		s1.go();
		s2.go();
		
		s1.attack();
		s2.attack();
		
		
	}
	
}
