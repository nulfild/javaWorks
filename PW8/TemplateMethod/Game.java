package PW8.TemplateMethod;

abstract class Game {

	abstract void initialize();

	abstract void start();

	abstract void end();

	public final void play() {
		initialize();
		start();
		end();
	}
}
