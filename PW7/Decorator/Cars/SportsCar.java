package PW7.Decorator.Cars;

import PW7.Decorator.ICar;

public class SportsCar extends CarDecorator {

	public SportsCar(ICar car) {
		super(car);
	}

	@Override
	public String getDescr() {
		return (
			"Not just a " +
			super.getDescr() +
			", but cool Sports Car"
		);
	}

	@Override
	public int getPrice() {
		return super.getPrice() + 5000;
	}
}
