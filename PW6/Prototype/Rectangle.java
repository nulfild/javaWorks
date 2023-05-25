package PW6.Prototype;

public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	@Override
	void draw() {
		System.out.println("Shape draw");
	}
}
