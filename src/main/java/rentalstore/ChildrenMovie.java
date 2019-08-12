package rentalstore;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double getRentalAmount(int dayRented) {
        double amount = 1.5;
        if (dayRented > 3) {
            amount += (dayRented - 3) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentRenterPoints(int getDayRented) {
        return 1;
    }
}
