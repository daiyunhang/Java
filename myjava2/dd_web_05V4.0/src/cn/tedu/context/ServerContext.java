package cn.tedu.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 	这个类用来提取服务器相关参数
 */
public class ServerContext {
	
	//1.声明4个变量
	public static int port;//服务器的端口号
	public static int maxSize;//最大线程数
	public static String protocol;//协议名和版本号
	public static String webRoot;//服务器资源存放的根目录
	
	//声明404页面
	public static String notFoundPage;
	
	//读取typemappings的值
	//map<ext的值,  type的值>--map<String,String>
	public static Map<String, String> typeMap = 
			new HashMap<String, String>();
	
	
	
	//2.静态代码块中完成初始化变量
	static {
		init();
	}

	//读取配置文件,给变量赋值
	private static void init() {
		try {
			//作为读取配置文件的核心对象
			SAXReader reader = new SAXReader();
			//读取指定位置的文件
			Document doc = reader.read("config/server.xml");
			//获取根节点server
			Element server = doc.getRootElement();
			//根据根节点获取根节点下的子节点service
			Element service = server.element("service");
			//根据service获取connect元素
			Element connect = service.element("connect");
			//获取connect身上的port的属性值
			port = Integer.valueOf(connect.attributeValue("port"));
			maxSize = Integer.valueOf(connect.attributeValue("maxSize"));
			protocol = connect.attributeValue("protocol");
			//获取webRoot身上的值
			webRoot = service.elementText("webRoot");
			
			//给404页面赋值
			notFoundPage = service.elementText("not-found-page");
			
			//给typeMap赋值
			List<Element> list = service.element("typemappings").elements();
			for (Element element : list) {
				//获取每行typemapping的ext的值
				String key = element.attributeValue("ext");
				String value = element.attributeValue("type");
				
				//把key和value存入typeMap
				//{html,text/html}
				typeMap.put(key, value);
			}
			
			
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		
		
	}
	
	
	
	
	
}
