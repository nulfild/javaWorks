package PW7.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

	private static Map<String, IShape> shapesMap = new HashMap<>();

	public static Circle getCircle(String color) {
		Circle shape = (Circle) shapesMap.get(color);

		if (shape == null) {
			shape = new Circle(color);
			shapesMap.put(color, shape);
		}

		return shape;
	}
}
