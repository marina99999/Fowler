package fowler;

import java.lang.*;
import java.util.*;

public class Customer {
	private final String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String newname) {
		name = newname;
	}

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		//double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> enum_rentals = rentals.elements();
		// String result = "Rental Record for " + this.getName() + "\n";
		// result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
		StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
		result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

		while (enum_rentals.hasMoreElements()) {
			// double thisAmount = 0;
			Rental each = (Rental) enum_rentals.nextElement();
			// determine amounts for each line
			// thisAmount = amountFor(each);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			// result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" +
			// each.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
			// totalAmount += thisAmount;
			result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t")
					.append(each.getDaysRented()).append("\t").append(each.getCharge()).append("\n");
		}
		// add footer lines
		// result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		// result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent
		// renter points";
		// return result;
		result.append("Amount owed is ").append(getTotalCharge()).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
		return result.toString();
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	/*
	 * private double amountFor(Rental each) { double thisAmount = 0; switch
	 * (each.getMovie().getPriceCode()) { case Movie.REGULAR: thisAmount += 2; if
	 * (each.getDaysRented() > 2) thisAmount += (each.getDaysRented() - 2) * 1.5;
	 * break; case Movie.NEW_RELEASE: thisAmount += each.getDaysRented() * 3; break;
	 * case Movie.CHILDRENS: thisAmount += 1.5; if (each.getDaysRented() > 3)
	 * thisAmount += (each.getDaysRented() - 3) * 1.5; break; } return thisAmount; }
	 */

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

}
