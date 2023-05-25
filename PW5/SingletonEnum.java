package PW5;

public enum SingletonEnum {
	INSTANCE("Value");

	private final String value;

	private SingletonEnum(String str) {
		this.value = str;
	}

	public String getValue() {
		return this.value;
	}

	public static SingletonEnum getInstance() {
		return INSTANCE;
	}
}
