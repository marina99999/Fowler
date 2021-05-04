package fowler;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private final String title;
	private final int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public String getTitle() {
		return title;
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
		if (this.priceCode == Movie.NEW_RELEASE && days > 1)
			return 2;
		else
			return 1;
	}
}