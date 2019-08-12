package rentalstore;

public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getRentalAmount(int dayRented) {
        double amount = 2;
        if (dayRented > 2) {
            amount += (dayRented - 2) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentRenterPoints(int getDayRented) {
        return 1;
    }
}
