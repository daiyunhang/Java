package dd_09_05_作业_学生;

public class Test1 {
	public static void main(String[] args) {
		Student s1 = new Student(1,"张三","男",22);
		Student s2 = new Student(1,"张三","男",22);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.equals(s2));
	}
}
