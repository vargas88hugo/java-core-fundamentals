package com.hashset01;

import java.util.*;

/**
 * This class consists in creates a solar system with its planets
 * and their moons by a hashSet. The planet instances are constituted 
 * by a name, orbital period and other hashSet that defines the moons.
 * The moon instances are almost the same as the planets but without 
 * a hashSet.
 */
public final class HeavenlyBody {
	private final String name;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites;
	
	public HeavenlyBody(String name, double orbitalPeriod) {
		this.name = name;
		this.orbitalPeriod = orbitalPeriod;
		this.satellites = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	public boolean addMoon(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}
	
	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}

	/**
	 * Method that defines a hashCode of type String
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Method that defines what will be the reference to
	 * compare the equality of the instances
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeavenlyBody other = (HeavenlyBody) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
