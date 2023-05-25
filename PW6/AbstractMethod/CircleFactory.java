package PW6.AbstractMethod;

public class CircleFactory extends ShapeFactory {

	@Override
	IShape getShape(ShapeType shapeType) {
		if (shapeType == ShapeType.CIRCLE) {
			return new Circle();
		}
		return null;
	}
}
