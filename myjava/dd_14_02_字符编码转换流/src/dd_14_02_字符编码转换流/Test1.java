package dd_14_02_�ַ�����ת����;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Test1 {
	public static void main(String[] args) throws Exception {
		/*
		 *	abc���Ć��F
		 *	f6�ļ�, ����GBK����
		 *	f7�ļ�, ����UTF-8����
		 *	
		 *	OSW--FOS--f6
		 * 	OSW--FOS--f7
		 */
		
		f("abc���Ć��F","d:/abc/f6","GBK");
		f("abc���Ć��F","d:/abc/f7","UTF-8");
		
	}

	private static void f(String s, String path, String encoding) throws Exception   {
		
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path),encoding);
		
		out.write(s);
		
		out.close();
		
		
		
	}
}
