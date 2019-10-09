package dd_14_02_�ַ�����ת����;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Test2 {
	public static void main(String[] args) throws Exception {
		
	
	/*
	 * ������������ַ�
	 * '\u4e00'��'\u9fa5'
	 * 
	 *  f8�ļ�����GBK
	 *  f9�ļ�����UTF-8
	 */
	
	f("d:/abc/f8","GBK");
	f("d:/abc/f9","UTF-8");
	
	}

	private static void f(String path, String encoding) throws Exception {
		OutputStreamWriter out =
		new OutputStreamWriter(new FileOutputStream(path),encoding);
		
		//4e00��9fa5
		//����ÿ30��,�ӻ���
		for(int i=0,c=0x4e00; c<=0x9fa5; i++,c++) {
			out.write(c);
			if(i%30 == 0) {
				out.write('\n');
			}
		}
		out.close();
		
		
		
	}	
}
