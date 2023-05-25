package PW8.TemplateMethod;

public class App {

	public static void main(String[] args) {
		Game game = new Football();
		game.play();

		game = new Hockey();
		game.play();
	}
}
