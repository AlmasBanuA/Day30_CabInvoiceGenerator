package com.day30;

/**
 * The cab service is a subscription based cab service, where the customer books
 * a cab, and pays the bill at the end of the month.
 * 
 * UC1: Calculate Fare - Given Distance and time the invoice generator should
 * return the total fare of journey - Cost Rs.10 per KM + Rs.1 per minute. -
 * Minimum Fare - Rs.5
 * 
 * UC2: Multiple Ride - The invoice generator should now take in multiple rides,
 * and calculate the aggregate total for all
 * 
 * UC3: Enhanced Invoice - The invoice generator should now return the following
 * as a part of the invoice -Total Number Of Rides - Total Fare - Average Fare
 * Per Ride
 * 
 * UC4: Invoice Service - Given a user id ,the invoice service gets the list of
 * rides from the ride repository, and return the invoice.
 * 
 * UC5: Premium Rides (Bonus) - The cab agency now supports 2 categories of
 * rides : - Normal Rides : Rs.10 per km, Rs.1 per minute, Minimum fare of Rs.5
 * - Premium Rides : Rs.15 per km, Rs.2 per minute, Minimum fare of Rs.20
 * 
 * @author user -Almas
 *
 */

public class InvoiceService {
	private RideRepository rideRepository;

	/**
	 * default constructor for InvoiceService
	 */
	public InvoiceService() {
		this.rideRepository = new RideRepository();
	}

	/**
	 * create method calculateFare for calculating both kind of rides Premium Rides
	 * and normal rides
	 * 
	 * @param ride
	 * @return
	 */
	public double calculateFare(Ride ride) {
		return Math.max(ride.rideCategory.minFare,
				ride.getDistance() * ride.rideCategory.costPerKm + ride.getTime() * ride.rideCategory.costPerTime);
	}

	/**
	 * InvoiceSummary method for getting the part of the invoice
	 * 
	 * @param rides
	 * @return
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	/**
	 * method created addRides for Given a user id
	 * 
	 * @param userId
	 * @param ride
	 */
	public void addRides(String userId, Ride[] ride) {
		rideRepository.addRide(userId, ride);
	}

	/**
	 * the invoice service gets the list of rides from the ride repository, and
	 * return the invoice
	 * 
	 * @param userId
	 * @return
	 */
	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

}
