package dd_06_05_����;

public class Student extends Person{
	String scholl;
	
	
	/**
	 * ��дtoString����
	 * �Ӹ����м̳еķ���
	 * �����������¶��壬���±�д
	 * */
	public String toString() {
		String s = super.toString();
		return s+", "+scholl;
	}
	
}
