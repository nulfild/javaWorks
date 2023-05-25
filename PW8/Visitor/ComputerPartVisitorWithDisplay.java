package PW8.Visitor;

import PW8.Visitor.Elements.Computer;
import PW8.Visitor.Elements.Keyboard;
import PW8.Visitor.Elements.Monitor;
import PW8.Visitor.Elements.Mouse;

public class ComputerPartVisitorWithDisplay
	implements IComputerVisitor {

	@Override
	public void visit(Computer computer) {
		System.out.println("Computer method");
	}
	
	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Keyboard method");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Monitor method");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Mouse method");
	}
}
