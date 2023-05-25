package PW8.Visitor;

import PW8.Visitor.Elements.Computer;
import PW8.Visitor.Elements.Keyboard;
import PW8.Visitor.Elements.Monitor;
import PW8.Visitor.Elements.Mouse;

public interface IComputerVisitor {
	void visit(Computer computer);
	void visit(Keyboard keyboard);
	void visit(Monitor computer);
	void visit(Mouse computer);
}
