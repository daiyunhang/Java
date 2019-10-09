package dd_12_02_File;

import java.io.File;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		System.out.println("输入文件夹：");
		String s = new Scanner(System.in).nextLine();
		File dir = new File(s);
		if(! dir.isDirectory()) {
			System.out.println("不是文件夹");
			return;
		}
		long size = dirLength(dir);
		System.out.println(size);
	
	
	}

	private static long dirLength(File dir) {
		/*
		 * [dir]
		 *  |-a
		 *  |-b
		 *  |-c
		 *  	|-...
		 *  *) 对dir目录列表
		 *  *) 把列表文件和文件夹代销类加在一起
		 *  *) 文件夹大小，用递归调用获取
		 * */
		//列表
		File[] files = dir.listFiles();
		if(files == null) {
			return 0;
		}
		
		//累加变量
		long sum = 0;
		
		//遍历子文件、子文件夹
		for(File f: files) {
			if(f.isFile()) {//f是文件
				sum += f.length();
			}else {//f是文件夹
				sum += dirLength(f);//递归求子文件夹大小
			}
		}
		
		return sum;
	}
}
