package rentalstore;

public class RegularMovie implements MovieType {

    @Override
    public double getAmount(int dayRented) {
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
