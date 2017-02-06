package com.nauka.design;

public class Car {

	String colour;
	private String wheels;
	private int type;
	
	
	private Car(CarBuilder cb) {
		this.colour = cb.getColour();
		this.wheels = cb.getWheels();
		this.type = cb.getType();
	}
	
	public static CarBuilder getCarBuilder(int type) {
		return new CarBuilder(type);
	}
			
	
	public static class CarBuilder {
		
		public Car build() {
			return new Car(this);
		}
		
		public String getColour() {
			return colour;
		}

		public CarBuilder setColour(String colour) {
			this.colour = colour;
			return this;
		}

		public String getWheels() {
			return wheels;
		}

		public CarBuilder setWheels(String wheels) {
			this.wheels = wheels;
			return this;
		}

		public int getType() {
			return type;
		}

		public CarBuilder setType(int type) {
			this.type = type;
			return this;
		}

		private String colour;
		private String wheels;
		private int type;
		
		private CarBuilder (int type) {
			this.type = type;
		}
	}
}
