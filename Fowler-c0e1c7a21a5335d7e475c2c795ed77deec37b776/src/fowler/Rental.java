package fowler;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double getCharge() {
		return this.movie.getCharge(this.daysRented);
	}

	public int getFrequentRenterPoints() {
		return (int) this.movie.getFrequentRenterPoints(this.daysRented);
	}
}