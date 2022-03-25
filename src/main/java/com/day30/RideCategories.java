package com.day30;

/**
 * Premium Rides (Bonus) - The cab agency now supports 2 categories of
 * rides : - Normal Rides : Rs.10 per km, Rs.1 per minute, Minimum fare of Rs.5
 * - Premium Rides : Rs.15 per km, Rs.2 per minute, Minimum fare of Rs.20
 */
public enum RideCategories {
	NORMAL_RIDE(10.0, 1, 5.0), PREMIUM_RIDE(15.0, 2, 20.0);

	public final double costPerKm;
	public final int costPerTime;
	public final double minFare;

	/**
	create parameterized constructor for RideCategories by passing parameters
	*/
        private RideCategories(double costPerKm, int costPerTime, double minFare) {
		this.costPerKm = costPerKm;
		this.costPerTime = costPerTime;
		this.minFare = minFare;
	}

	/**
	method created to calculate total Fare of both premium and normal rides
	*/
	public double calculateFare(Ride ride) {
		return Math.max((ride.getDistance() * costPerKm) + (ride.getTime() * costPerTime), minFare);
	}
}
