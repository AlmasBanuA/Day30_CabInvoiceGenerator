package com.day30;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InvoiceGeneratorTest {

	/**
	 * test cases for CabInvoice Generator
	 */
	@Test
	/**
	 * created method for calculating the total fare by giving distance and time for
	 * the total fare will be more than 10
	 */
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
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
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
}
