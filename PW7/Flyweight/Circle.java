package PW7.Flyweight;

public class Circle implements IShape {

	private String color;
	private int x;
	private int y;
	private int radius;

	public Circle(String color) {
		this.color = color;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println(
			"Circle.draw() [color=" +
			color +
			", x=" +
			x +
			", y=" +
			y +
			", radius=" +
			radius +
			"]"
		);
	}
}
