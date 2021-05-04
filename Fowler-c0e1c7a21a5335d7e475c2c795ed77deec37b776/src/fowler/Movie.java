package fowler;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private final String _title;
	private final int _priceCode;

	public Movie(String title, int priceCode) {
		this._title = title;
		this._priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(int days) {
		double result = 0;
		switch (this.getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (days > 2)
				result += (days - 2) * 1.5;
			break;

		case Movie.NEW_RELEASE:
			result += days * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (days > 3)
				result += (days - 3) * 1.5;
			break;
		default:
			System.out.println("Sorry");
		}
		return result;
	}

	public Object getFrequentRenterPoints(int days) {
		if (this._priceCode == Movie.NEW_RELEASE && days > 1)
			return 2;
		else
			return 1;
	}
}