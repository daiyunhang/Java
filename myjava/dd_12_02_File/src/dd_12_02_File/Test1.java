package dd_12_02_File;

import java.io.File;

public class Test1 {
	public static void main(String[] args) {
		String path;
		
//		path = "D:\\ecl.exe";//存在的文件
//		path = "D:\\a";//存在的文件夹
		path = "x:\\ff\\aa\\bb";//不存在的路径
		
		File file = new File(path);
		System.out.println(file.exists());//是否存在
		System.out.println(file.length());//字节量，文件夹无效
		System.out.println(file.isFile());//是否是文件
		System.out.println(file.isDirectory());//是否是文件夹
		
	}
}
