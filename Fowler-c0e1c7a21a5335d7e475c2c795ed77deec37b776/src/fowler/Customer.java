package fowler;

import java.lang.*;
import java.util.*;

public class Customer {
	private final String _name;
	private Vector<Rental> _rentals = new Vector<>();

	public Customer(String name) {
		this._name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {

		int frequentRenterPoints = 0;
		Enumeration<Rental> enum_rentals = _rentals.elements();
		StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
		result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

		while (enum_rentals.hasMoreElements()) {

			Rental each = enum_rentals.nextElement();
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			result.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t")
					.append(each.getDaysRented()).append("\t").append(each.getCharge()).append("\n");
		}
		// add footer lines
		result.append("Amount owed is ").append(getTotalCharge()).append("\n");
		result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
		return result.toString();
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = this._rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
	
}
