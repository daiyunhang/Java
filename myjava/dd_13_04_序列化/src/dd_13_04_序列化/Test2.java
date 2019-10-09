package dd_13_04_序列化;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		/*
		 * 从f5文件读取序列化数据
		 * 反序列化恢复学生对象
		 * 
		 * OIS--FIS--f5
		 * 
		 */
		ObjectInputStream in =
		new ObjectInputStream(new FileInputStream("d:/abc/f5"));
		
		Student s = (Student) in.readObject();
		System.out.println(s);
		in.close();
		
		
		
		
	}
}
