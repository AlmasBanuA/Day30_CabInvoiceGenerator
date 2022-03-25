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
		double distance = 1.0;
		int time = 10;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(20, fare, 0.0);
	}

	@Test
	/**
	 * created method for calculating the fare by giving distance and time for the
	 * total fare will be less than 10 will gives the Minimum fare
	 */
	public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}

	@Test
	/**
	 * created method givenMultipleRidesShouldReturnRideSummary() here given
	 * multiple rides should return the ride summary
	 */
	public void givenMultipleRidesShouldReturnRideSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
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
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary checkSummary = new InvoiceSummary(2, 30.0);
		assertEquals(summary, checkSummary);
	}
}
