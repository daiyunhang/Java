package dd_14_01_字符编码转换;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) throws Exception {
		String s = "abc中文喆镕";
		System.out.println(s);
		
		f(s,null);
		f(s,"GBK");
		f(s,"GB2312");
		f(s,"UTF-8");
		
		
		
		
	}

	private static void f(String s, String encoding) throws Exception {
		//Unicode 转其他编码
		byte[] a;
		if(encoding == null) {
			a = s.getBytes();//转成系统默认编码
		}else {
			a = s.getBytes(encoding);
		}
		
		System.out.println(encoding+"\t"+Arrays.toString(a));
		
	}
}
