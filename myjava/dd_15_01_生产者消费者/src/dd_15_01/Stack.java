package dd_15_01;

public class Stack {
	private char[] a = new char[5];
	private int index;
	
	public void push(char c)
	{
		a[index] = c;
		index++;
	}
	
	public char pop()
	{
		index--;
		char c = a[index];
		return c;
	}
	public boolean isEmpty()
	{
		return index == 0;
	}
	
	public boolean isFull()
	{
		return index == 5;
	}
}
