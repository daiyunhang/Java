package dd_08_02_学生;

public class Student {
	/**
	 * 成员变量，一般都设计成私有
	 * 可以使用公开的方法，来控制变量的赋值及访问
	 * 
	 * 如果类中的成员变量非常多，为了同包调用方便，可以选择[default]
	 * 如果希望子类集成这个变量，可以使用protected
	 * */
	
	private int id;
	private String name;
	private String gender;
	private int age;
	public Student() {}
	public Student(int id, String name, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}

