package dd_03_02_兔子和鸡练习题;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("兔子和鸡一共有48只");
		System.out.println("有108只脚");
		System.out.println("兔子和鸡各有多少只");

		/**
		 *  i  j
		 *  0  48   xxx
		 *  1  47   xxx
		 *  ...
		 *  48 0    xxx  
		 * */
		for(int i=0,j=48; i<=48; i++,j--){
			int n = i*4 + j*2;
			if(n == 108){
				System.out.println("兔子:"+i+   "鸡:"+ j);
			}
		}
	}
}
