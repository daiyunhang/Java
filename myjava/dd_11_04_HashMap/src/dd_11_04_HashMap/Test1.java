package dd_11_04_HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(9527, "С��");
		map.put(9528, "С��");
		map.put(9529, "С��");
		map.put(9530, "С��");
		map.put(9531, "С��");
		map.put(9532, "С��");
		//�ظ��ļ����µ�ֵ������ǰ��ֵ
		map.put(9528, "�԰�");
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get(9527));
		System.out.println(map.get(9999));//�����ڵõ�null
		System.out.println(map.remove(9527));//���ر�ɾ��������ֵ
		//ȡ�����еļ�
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
