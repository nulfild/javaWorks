package PW6.AbstractFactory.Shapes;

import PW6.AbstractFactory.AbstractFactory;
import PW6.AbstractFactory.Colors.ColorTypes;
import PW6.AbstractFactory.Colors.IColor;

public class ShapeFactory implements AbstractFactory {

	@Override
	public IShape getShape(ShapeTypes shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType == ShapeTypes.CIRCLE) {
			return new Circle();
		} else if (shapeType == ShapeTypes.SQUARE) {
			return new Square();
		}
		return null;
	}

	@Override
	public IColor getColor(ColorTypes colorType) {
		return null;
	}
}
