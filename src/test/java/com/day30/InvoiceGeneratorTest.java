package com.day30;

/**
 * In TDD approach First Write the test before writing the implementation code
 */
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
	InvoiceService invoiceService;

	/**
	 * Annotating a public void method with @Before causes that method to be run
	 * before the Test method.
	 */
	@Before
	public void init() {
		invoiceService = new InvoiceService();
	}

	/**
	 * test cases for CabInvoice Generator
	 */
	@Test
	/**
	 * created method for calculating the total fare by giving distance and time for
	 * the total fare will be more than 10
	 */
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		Ride ride = new Ride(RideCategories.NORMAL_RIDE, 1.0, 10);
		double fare = invoiceService.calculateFare(ride);
		assertEquals(20, fare, 0.0);
	}

	@Test
	/**
	 * created method for calculating the fare by giving distance and time for the
	 * total fare will be less than 10 will gives the Minimum fare
	 */
	public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
		Ride ride = new Ride(RideCategories.NORMAL_RIDE, 0.1, 1);
		double fare = invoiceService.calculateFare(ride);
		assertEquals(5, fare, 0.0);
	}

	@Test
	/**
	 * created method givenMultipleRidesShouldReturnRideSummary() here given
	 * multiple rides should return the ride summary
	 */
	public void givenMultipleRidesShouldReturnRideSummary() {
		Ride[] rides = { new Ride(RideCategories.NORMAL_RIDE, 2.0, 5), new Ride(RideCategories.NORMAL_RIDE, 0.1, 1) };
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		assertEquals(expectedSummary, summary);
	}

	@Test
	/**
	 * method created addRides for Given a user id and the invoice service gets the
	 * list of rides from the ride repository, and return the invoice
	 */
	public void givenUserIdShouldReturnTheInvoice() {
		String userId = "abc@123";
		Ride[] rides = { new Ride(RideCategories.NORMAL_RIDE, 2.0, 5), new Ride(RideCategories.NORMAL_RIDE, 0.1, 1) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary checkSummary = new InvoiceSummary(2, 30.0);
		assertEquals(summary, checkSummary);
	}

	@Test
	/**
	 * method for 2 categories of rides : - Normal Rides : Rs.10 per km, Rs.1 per
	 * minute, Minimum fare of Rs.5 - Premium Rides : Rs.15 per km, Rs.2 per minute,
	 * Minimum fare of Rs.20
	 * 
	 */
	public void givenUserIdWithPremiumRideShouldReturnTheInvoice() {
		String userId = "pqr@123";
		Ride[] rides = { new Ride(RideCategories.NORMAL_RIDE, 2.0, 5), new Ride(RideCategories.NORMAL_RIDE, 0.1, 1),
				new Ride(RideCategories.PREMIUM_RIDE, 0.1, 1) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary checkSummary = new InvoiceSummary(3, 50.0);
		assertEquals(summary, checkSummary);
	}
}
