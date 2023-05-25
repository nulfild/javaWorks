package PW5;

public class SingletonClass1 {

	private static SingletonClass1 instance = new SingletonClass1();

	private SingletonClass1() {}

	public static SingletonClass1 getInstance() {
		return instance;
	}
}
