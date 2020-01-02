package com.equalsissue;

/**
 * This program demonstrates an issue with the equals method
 * when the object is compared with a subclass and viceversa.
 * It is necessary to define one equals method in the superclass
 * and configure it with the keyword final to not allow overriding.
 * @author Hugo Vargas
 * @version 1.0 2020-01-02
 */
public class Main {

	public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
	}

}
