package dd_06_05_����;

public class Test1 {
	public static void main(String[] args) {
		Person p = new Person("����","��",22);
		Student s = new Student();
		Employee e = new Employee();
		s.name = "����";
		s.gender = "Ů";
		s.age = 21;
		s.scholl = "ţ����ѧ";
		
		e.name = "����";
		e.gender = "��";
		e.age = 19;
		e.salary = 8000;
		
		System.out.println(p.toString());
		System.out.println(s.toString());
		System.out.println(e.toString());
		
		f(p);
		f(s);//����ת��
		f(e);
	}
	static void f(Person p) {
		System.out.println("����������Person������");
		System.out.println(p.toString());
	}
}
