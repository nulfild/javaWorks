package PW8.Visitor;

import PW8.Visitor.Elements.Computer;

public class App {

	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.accept(new ComputerPartVisitorWithDisplay());
	}
}
