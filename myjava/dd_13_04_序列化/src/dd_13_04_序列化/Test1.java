package dd_13_04_序列化;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*
		 * Student对象,序列化输出,保存到文件
		 * 
		 *  OOS--FOS--f5
		 *  
		 */
		Student s =
		new Student(9527,"唐伯虎","男",19);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/abc/f5"));
		//序列化学生对象
		out.writeObject(s);
		
		out.close();
	}
	
}
