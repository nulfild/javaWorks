package PW8.TemplateMethod;

public class Hockey extends Game {

	@Override
	void initialize() {
		System.out.println("Hockey game initialized");
	}

	@Override
	void start() {
		System.out.println("Hockey game started");
	}

	@Override
	void end() {
		System.out.println("Hockey game ended");
	}
}
