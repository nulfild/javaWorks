package PW6.AbstractFactory;

import PW6.AbstractFactory.Colors.ColorTypes;
import PW6.AbstractFactory.Colors.IColor;
import PW6.AbstractFactory.Shapes.IShape;
import PW6.AbstractFactory.Shapes.ShapeTypes;

public class App {

	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory(
			FactoryTypes.SHAPE
		);
		IShape shape1 = shapeFactory.getShape(
			ShapeTypes.SQUARE
		);
		shape1.draw();
		IShape shape2 = shapeFactory.getShape(
			ShapeTypes.CIRCLE
		);
		shape2.draw();

		AbstractFactory colorFactory = FactoryProducer.getFactory(
			FactoryTypes.COLOR
		);
		IColor color1 = colorFactory.getColor(ColorTypes.RED);
		color1.fill();
		IColor color2 = colorFactory.getColor(
			ColorTypes.GREEN
		);
		color2.fill();
	}
}
