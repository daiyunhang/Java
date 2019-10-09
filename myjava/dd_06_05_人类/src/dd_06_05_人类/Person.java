package dd_06_05_ÈËÀà;

public class Person {
	String name;
	String gender;
	int age;
	
	public Person() {
		
	}
	public Person(String name,String gender,int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String toString() {
		return name+", "+gender+", "+age;
	}
}
