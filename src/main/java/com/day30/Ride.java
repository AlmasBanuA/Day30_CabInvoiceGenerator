package com.day30;

public class Ride {

	/**
	 * private variables can only be accessed within the same class (an outside
	 * class has no access to it) private = restricted access However, it is
	 * possible to access them if we provide public get and set methods.
	 */
	private double distance;
	private int time;

	/**
	 * create parameterized constructor of Ride class by passing distance and time
	 * 
	 * @param distance
	 * @param time
	 */
	public Ride(double distance, int time) {
		this.distance = distance;
		this.time = time;
	}

	/**
	 * created getter setter methods
	 * 
	 * @return
	 */
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
