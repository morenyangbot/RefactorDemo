package rentalstore;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getRentalAmount(int dayRented) {
        return dayRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int getDayRented) {
        if (getDayRented > 1) {
            return 2;
        }
        return 1;
    }
}
