package dd_12_02_File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 新建d:\abc 目录
		 * 新建d:\abc\f1 文件
		 * 删除 f1 文件
		 * 删除 abc 目录
		 */
		
		System.out.println("按回车");
		new Scanner(System.in).nextLine();
		File dir = new File("d:/abc");
		dir.mkdirs();
		
		//
		new Scanner(System.in).nextLine();
		File file = new File("d:/abc/f1");
		file.createNewFile();
		
		
		//删除
		System.out.println("按回车");
		new Scanner(System.in).nextLine();
		file.delete();
		
		
	}
}
