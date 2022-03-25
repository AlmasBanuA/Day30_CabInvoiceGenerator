package com.day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<String, ArrayList<Ride>> userRides;

	public RideRepository() {
		userRides = new HashMap<String, ArrayList<Ride>>();
	}

	/**
	 * method created addRides for Given a user id
	 * 
	 * @param userId
	 * @param ride
	 */
	public void addRide(String userId, Ride[] ride) {
		ArrayList<Ride> ridesList = this.userRides.get(userId);
		if (ridesList == null) {
			this.userRides.put(userId, new ArrayList<Ride>(Arrays.asList(ride)));
		}

	}

	/**
	 * the invoice service gets the list of rides from the ride repository, and
	 * return the invoice
	 * 
	 * @param userId
	 * @return
	 */
	public Ride[] getRides(String userId) {
		return this.userRides.get(userId).toArray(new Ride[0]);
	}
}
