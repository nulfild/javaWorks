package PW7.Decorator.Cars;

import PW7.Decorator.ICar;

public class BasicCar implements ICar {

	@Override
	public String getDescr() {
		return "Basic Car";
	}

	@Override
	public int getPrice() {
		return 10000;
	}
}
