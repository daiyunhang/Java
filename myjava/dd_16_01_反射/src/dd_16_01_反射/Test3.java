package dd_16_01_反射;

import java.lang.reflect.Field;

public class Test3 {
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		Class c = Integer.class;
		Integer a = Integer.valueOf(5);
		
		//获得成员变量value
		Field f = c.getDeclaredField("value");
		//私有变量可以访问
		f.setAccessible(true);
		//获得变量的值
		Object v = f.get(a);
		System.out.println(v);
		
		//修改a对象中,该变量的值
		f.set(a, 555);
		System.out.println(a);
	}
}
