package cn.tedu.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 	�����������ȡ��������ز���
 */
public class ServerContext {
	
	//1.����4������
	public static int port;//�������Ķ˿ں�
	public static int maxSize;//����߳���
	public static String protocol;//Э�����Ͱ汾��
	public static String webRoot;//��������Դ��ŵĸ�Ŀ¼
	
	//����404ҳ��
	public static String notFoundPage;
	
	//��ȡtypemappings��ֵ
	//map<ext��ֵ,  type��ֵ>--map<String,String>
	public static Map<String, String> typeMap = 
			new HashMap<String, String>();
	
	
	
	//2.��̬���������ɳ�ʼ������
	static {
		init();
	}

	//��ȡ�����ļ�,��������ֵ
	private static void init() {
		try {
			//��Ϊ��ȡ�����ļ��ĺ��Ķ���
			SAXReader reader = new SAXReader();
			//��ȡָ��λ�õ��ļ�
			Document doc = reader.read("config/server.xml");
			//��ȡ���ڵ�server
			Element server = doc.getRootElement();
			//���ݸ��ڵ��ȡ���ڵ��µ��ӽڵ�service
			Element service = server.element("service");
			//����service��ȡconnectԪ��
			Element connect = service.element("connect");
			//��ȡconnect���ϵ�port������ֵ
			port = Integer.valueOf(connect.attributeValue("port"));
			maxSize = Integer.valueOf(connect.attributeValue("maxSize"));
			protocol = connect.attributeValue("protocol");
			//��ȡwebRoot���ϵ�ֵ
			webRoot = service.elementText("webRoot");
			
			//��404ҳ�渳ֵ
			notFoundPage = service.elementText("not-found-page");
			
			//��typeMap��ֵ
			List<Element> list = service.element("typemappings").elements();
			for (Element element : list) {
				//��ȡÿ��typemapping��ext��ֵ
				String key = element.attributeValue("ext");
				String value = element.attributeValue("type");
				
				//��key��value����typeMap
				//{html,text/html}
				typeMap.put(key, value);
			}
			
			
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		
		
	}
	
	
	
	
	
}
