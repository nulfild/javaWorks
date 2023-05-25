package PW8.Visitor;

public interface IComputerPart {
	void accept(IComputerVisitor computerVisitor);
}
