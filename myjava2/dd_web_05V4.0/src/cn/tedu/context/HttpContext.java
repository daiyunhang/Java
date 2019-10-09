package cn.tedu.context;

import java.util.HashMap;
import java.util.Map;

/**
 * �����������װhttpЭ����ص���Ϣ
 * 1.������Ӧ��״̬��,״̬���������Ϣ
 * 2.��װ��map�Ľṹ
 * 3.�ھ�̬�����������map��ֵ
 * 4.����
 */
public class HttpContext {
	//1.������Ӧ��״̬��
	public static final int CODE_OK = 200;
	public static final int CODE_ERROR = 500;
	public static final int CODE_NOTFOUND = 404;
	
	//״̬���������Ϣ
	public static final String DESC_OK = "OK";
	public static final String DESC_ERROR = "ERROR";
	public static final String DESC_NOTFOUND = "NOT FOUND";
	
	//2.��װ��map�Ľṹ
	//key��״̬��,value������
	public static Map<Integer, String> map = new HashMap<Integer, String>();
	
	//3.�ھ�̬�����������map��ֵ
	static {
		map.put(CODE_OK, DESC_OK);
		map.put(CODE_ERROR, DESC_ERROR);
		map.put(CODE_NOTFOUND, DESC_NOTFOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
