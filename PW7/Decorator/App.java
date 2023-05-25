package PW7.Decorator;

import PW7.Decorator.Cars.BasicCar;
import PW7.Decorator.Cars.SportsCar;

public class App {

	public static void main(String[] args) {
		ICar basicCar = new BasicCar();
		System.out.println(basicCar.getDescr());
		System.out.println(basicCar.getPrice());

		ICar sportsCar = new SportsCar(basicCar);
		System.out.println(sportsCar.getDescr());
		System.out.println(sportsCar.getPrice());
	}
}
