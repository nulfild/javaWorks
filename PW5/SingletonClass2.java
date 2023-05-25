package PW5;

public class SingletonClass2 {

	private static SingletonClass2 instance;

	private SingletonClass2() {}

	public static SingletonClass2 getInstance() {
		if (instance == null) {
			instance = new SingletonClass2();
		}
		return instance;
	}
}
