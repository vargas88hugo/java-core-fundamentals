package com.hashset02;

import java.util.*;

/**
 * This class consists in creates a solar system with its planets
 * and their moons by a hashSet. The planet instances are constituted 
 * by a name, orbital period and other hashSet that defines the moons.
 * The moon instances are almost the same as the planets but without 
 * a hashSet.
 */
public abstract class HeavenlyBody2 {
	private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody2> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody2(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public boolean addSatellite(HeavenlyBody2 moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody2> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj instanceof HeavenlyBody2) {
            HeavenlyBody2 theObject = (HeavenlyBody2) obj;
            if(this.name.equals(theObject.getName())) {
                return this.bodyType == theObject.getBodyType();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 57;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }
}
