package dd_12_01;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) { 
		try {
			f();
		} catch (ParseException e) {
			System.out.println("日期格式错误");
			//打印完整的异常信息，打印栈的追踪信息
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件创建失败");
			e.printStackTrace();
		}
	}

	private static void f() throws ParseException, IOException {
		System.out.print("生日：");
		String s = new Scanner(System.in).nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(s);
		String path = "d:\\"+d.getTime()+".txt";
		File file = new File(path);
		file.createNewFile();
	}
}
