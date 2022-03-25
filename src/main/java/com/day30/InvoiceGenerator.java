package com.day30;

/**
 * The cab service is a subscription based cab service, where the customer books
 * a cab, and pays the bill at the end of the month.
 * 
 * UC1: Calculate Fare - Given Distance and time the invoice generator should
 * return the total fare of journey - Cost Rs.10 per KM + Rs.1 per minute. -
 * Minimum Fare - Rs.5
 * 
 * @author user -Almas
 *
 */

public class InvoiceGenerator {

	/**
	 * the variables is only visible within the class, not from any other class
	 * (including subclasses). The visibility of private members extends to nested
	 * classes. private final static -> create this variable only once.
	 */
	private static final int COST_PER_TIME = 1;
	private static final double COST_PER_KM = 10;
	private static final double MINIMUM_FARE = 5;

	/**
	 * create method to calculate total fare as per distance and time
	 * 
	 * @param distance -distance of per km cost is 10 rs
	 * @param time     -per minute cost is 1rs
	 * @return total fare -total fare to be calulated
	 */
	public double calculateFare(double distance, int time) {
		return Math.max(MINIMUM_FARE, distance * COST_PER_KM + time * COST_PER_TIME);
	}

	/**
	 * Main method for manipulation of TDD aproach
	 * 
	 * @param args - Default Java param (Not used)
	 */
	public static void main(String[] args) {
		/**
		 * create Instance of InvoiceGenerator class,
		 */
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		/**
		 * calling CalculateFare method from InvoiceGenerator object and print o/p
		 */
		System.out.println(invoiceGenerator.calculateFare(5, 20) + " Rs");
	}

}
