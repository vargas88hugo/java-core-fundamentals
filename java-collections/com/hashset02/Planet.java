package com.hashset02;

public class Planet extends HeavenlyBody2 {

	public Planet(String name, double orbitalPeriod) {
		super(name, orbitalPeriod, BodyTypes.PLANET);
	}

	@Override
	public boolean addSatellite(HeavenlyBody2 moon) {
		if (moon.getBodyType() == BodyTypes.MOON) {
			return super.addSatellite(moon);
		} else {
			return false;
		}
	}

}
