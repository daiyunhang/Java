package dd_06_05_人类;

public class Test1 {
	public static void main(String[] args) {
		Person p = new Person("张三","男",22);
		Student s = new Student();
		Employee e = new Employee();
		s.name = "李四";
		s.gender = "女";
		s.age = 21;
		s.scholl = "牛蹄筋大学";
		
		e.name = "王五";
		e.gender = "男";
		e.age = 19;
		e.salary = 8000;
		
		System.out.println(p.toString());
		System.out.println(s.toString());
		System.out.println(e.toString());
		
		f(p);
		f(s);//向上转型
		f(e);
	}
	static void f(Person p) {
		System.out.println("当做如类型Person来处理");
		System.out.println(p.toString());
	}
}
