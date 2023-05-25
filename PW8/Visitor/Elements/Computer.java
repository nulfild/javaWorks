package PW8.Visitor.Elements;

import PW8.Visitor.IComputerPart;
import PW8.Visitor.IComputerVisitor;
import java.util.ArrayList;
import java.util.List;

public class Computer implements IComputerPart {

	List<IComputerPart> computerParts = new ArrayList<>();

	public Computer() {
		computerParts.add(new Keyboard());
		computerParts.add(new Mouse());
		computerParts.add(new Monitor());
	}

	@Override
	public void accept(IComputerVisitor computerVisitor) {
		computerParts.forEach(computerPart -> {
			computerPart.accept(computerVisitor);
		});

		computerVisitor.visit(this);
	}
}
