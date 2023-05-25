package PW6.AbstractFactory.Colors;

import PW6.AbstractFactory.AbstractFactory;
import PW6.AbstractFactory.Shapes.IShape;
import PW6.AbstractFactory.Shapes.ShapeTypes;

public class ColorFactory implements AbstractFactory {

	@Override
	public IShape getShape(ShapeTypes shapeType) {
		return null;
	}

	@Override
	public IColor getColor(ColorTypes colorType) {
		if (colorType == null) {
			return null;
		}
		if (colorType == ColorTypes.RED) {
			return new Red();
		} else if (colorType == ColorTypes.GREEN) {
			return new Green();
		}
		return null;
	}
}
