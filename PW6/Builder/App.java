package PW6.Builder;

public class App {

	public static void main(String[] args) {
		User user = new User.UserBuilder("John", "Doe")
			.age(30)
			.phone("1234567890")
			.address("1 Main St")
			.build();

		System.out.println(user);
	}
}
