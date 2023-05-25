package PW6.AbstractFactory;

import PW6.AbstractFactory.Colors.ColorFactory;
import PW6.AbstractFactory.Shapes.ShapeFactory;

class FactoryProducer {

	static AbstractFactory getFactory(FactoryTypes choice) {
		if (choice == FactoryTypes.SHAPE) {
			return new ShapeFactory();
		} else if (choice == FactoryTypes.COLOR) {
			return new ColorFactory();
		}
		return null;
	}
}
