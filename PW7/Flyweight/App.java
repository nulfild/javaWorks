package PW7.Flyweight;

public class App {

	public static void main(String[] args) {
		IShape circle1 = ShapeFactory.getCircle("green");
		circle1.setX(10);
		circle1.setY(5);
		circle1.draw();

		IShape circle2 = ShapeFactory.getCircle("red");
		circle2.draw();

		IShape circle3 = ShapeFactory.getCircle("green");
		circle3.draw();
	}
}
