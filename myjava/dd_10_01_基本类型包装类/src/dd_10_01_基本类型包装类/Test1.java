package dd_10_01_基本类型包装类;

public class Test1 {
	public static void main(String[] args) {
		Integer a = new Integer(5);//新分配内存
		Integer b = Integer.valueOf(5); //访问缓存对象
		Integer c = Integer.valueOf(5);//访问缓存对象
		
		System.out.println(a==b);//内存地址不同
		System.out.println(b==c);//内存地址相同
		System.out.println(a.equals(b));//比较封装的值
		
		
		System.out.println(a.byteValue());
		System.out.println(a.shortValue());
		System.out.println(a.intValue());
		System.out.println(a.longValue());
		System.out.println(a.floatValue());
		System.out.println(a.doubleValue());
		
		System.out.println(Integer.parseInt("255"));
		System.out.println(Integer.parseInt("11111111",2));
		
		//进制转换
		System.out.println(Integer.toBinaryString(255));
		System.out.println(Integer.toOctalString(255));
		System.out.println(Integer.toHexString(255));
		

	}
	
}
