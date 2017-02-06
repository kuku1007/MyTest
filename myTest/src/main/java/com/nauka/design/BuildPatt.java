package com.nauka.design;

import com.nauka.design.Car.CarBuilder;

public class BuildPatt {
	public static void main(String [] args) {
		Car c = Car.getCarBuilder(2).setColour("whie").setWheels("4").build();
		Car c2 = Car.getCarBuilder(2).setColour("whie").setWheels("4").build();
		
		System.out.println("white".hashCode() + "," + "white".hashCode());
	}
}
