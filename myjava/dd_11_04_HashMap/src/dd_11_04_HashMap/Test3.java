package dd_11_04_HashMap;

import java.util.HashMap;

public class Test3 {
	public static void main(String[] args) {
		Student s1 = new Student(1, "����", "��", 9);
		Student s2 = new Student(1, "����", "��", 9);
		
		//��ϣֵ������ͬ�����ܱ�֤�������ͬλ��
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		//��ʱ�±���ͬ��equale()ҲҪ��Ȳ��ܸ���
		System.out.println(s1.equals(s2));
		
		HashMap<Student, Integer> map = new HashMap<>();
		map.put(s1, 95);
		map.put(s2, 90);
		System.out.println(map);
	}
}