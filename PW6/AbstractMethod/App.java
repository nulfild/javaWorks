package PW6.AbstractMethod;

public class App {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new SquareFactory();
		IShape shape1 = shapeFactory.getShape(
			ShapeType.SQUARE
		);
		shape1.draw();

		shapeFactory = new CircleFactory();
		IShape shape2 = shapeFactory.getShape(
			ShapeType.CIRCLE
		);
		shape2.draw();
	}
}
