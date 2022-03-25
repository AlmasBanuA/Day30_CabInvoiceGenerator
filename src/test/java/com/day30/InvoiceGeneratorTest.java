package com.day30;

/**
 * In TDD approach First Write the test before writing the implementation code
 */
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
	InvoiceGenerator invoiceGenerator;

	/**
	 * Annotating a public void method with @Before causes that method to be run
	 * before the Test method.
	 */
	@Before
	public void init() {
		invoiceGenerator = new InvoiceGenerator();
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
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(20, fare, 0.0);
	}

	@Test
	/**
	 * created method for calculating the total fare by giving distance and time for
	 * the total fare will be less than 10
	 */
	public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}

	@Test
	/**
	 * created method to calculate total fare for multiple rides
	 */
	public void givenMultipleRidesShouldReturnTotalFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double fare = invoiceGenerator.calculateFare(rides);
		assertEquals(30, fare, 0.0);
	}
}
