package PW6.Prototype;

import java.util.ArrayList;
import java.util.List;

public class 	App {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle());
		shapes.add(new Rectangle());
		shapes.add(new Circle());

		Shape shape1 = shapes.get(0).clone();
		Shape shape2 = shapes.get(1).clone();

		shape1.draw();
		shape2.draw();
	}
}
