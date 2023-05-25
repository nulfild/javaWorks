package PW8.Visitor.Elements;

import PW8.Visitor.IComputerPart;
import PW8.Visitor.IComputerVisitor;

public class Monitor implements IComputerPart {

	@Override
	public void accept(IComputerVisitor computerVisitor) {
		computerVisitor.visit(this);
	}
}
