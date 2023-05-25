package PW6.AbstractFactory;

import PW6.AbstractFactory.Colors.ColorTypes;
import PW6.AbstractFactory.Colors.IColor;
import PW6.AbstractFactory.Shapes.IShape;
import PW6.AbstractFactory.Shapes.ShapeTypes;

public interface AbstractFactory {
	abstract IShape getShape(ShapeTypes shapeType);

	abstract IColor getColor(ColorTypes colorType);
}
