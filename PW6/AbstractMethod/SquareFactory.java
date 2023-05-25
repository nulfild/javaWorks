package PW6.AbstractMethod;

public class SquareFactory extends ShapeFactory {

	@Override
	IShape getShape(ShapeType shapeType) {
		if (shapeType == ShapeType.SQUARE) {
			return new Square();
		}
		return null;
	}
}
