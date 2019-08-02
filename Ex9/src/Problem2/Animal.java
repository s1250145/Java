package Problem2;

public abstract class Animal {
	private static int count;
	public void increment() {
		count++;
	}
	public static int getCount() { return count;}
	abstract void noise();
}
