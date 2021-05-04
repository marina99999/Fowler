package fowler;

public class Rental {
	private final Movie _movie;
	private final int _daysRented;

	public Rental(Movie movie, int daysRented) {
		this._movie = movie;
		this._daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double getCharge() {
		return this._movie.getCharge(this._daysRented);
	}

	public int getFrequentRenterPoints() {
		return (int) this._movie.getFrequentRenterPoints(this._daysRented);
	}
}