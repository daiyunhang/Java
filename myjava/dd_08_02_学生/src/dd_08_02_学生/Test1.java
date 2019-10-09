package dd_08_02_学生;

public class Test1 {
	public static void main(String[] args) {
		Student s = new Student();
		s.setId(9527);
		s.setName("代先生");
		s.setGender("男");
		s.setAge(19);
		
		
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getGender());
		System.out.println(s.getAge());
	}
}
