package dd_06_04_ѧ��;

public class Test1 {
	public static void main(String[] args) {
	
		Student s1 = new Student();
		Student s2 = new Student(5, "�ٻ�");
		Student s3 = new Student(6, "����", "��");
		Student s4 = new Student(7, "����", "Ů", 21);
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println(s4.toString());
		
	}
	
}
