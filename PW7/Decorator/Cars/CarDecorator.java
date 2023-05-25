package PW7.Decorator.Cars;

import PW7.Decorator.ICar;

abstract class CarDecorator implements ICar {

	protected ICar car;

	public CarDecorator(ICar car) {
		this.car = car;
	}

	@Override
	public String getDescr() {
		return car.getDescr();
	}

	@Override
	public int getPrice() {
		return car.getPrice();
	}
}
