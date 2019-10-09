package dd_11_04_HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(9527, "小红");
		map.put(9528, "小蓝");
		map.put(9529, "小绿");
		map.put(9530, "小白");
		map.put(9531, "小黑");
		map.put(9532, "小青");
		//重复的键，新的值覆盖以前的值
		map.put(9528, "赵安");
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get(9527));
		System.out.println(map.get(9999));//不存在得到null
		System.out.println(map.remove(9527));//返回被删除数据是值
		//取出所有的键
		Set<Integer> keys = map.keySet();
		for(Iterator<Integer> it=keys.iterator();it.hasNext();) {
			Integer k = it.next();
			String v = map.get(k);
			System.out.println(k+"="+v);
		}
		System.out.println(map.keySet());
		System.out.println(map.values());
	}
	
}
