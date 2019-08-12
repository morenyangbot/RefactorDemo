package rentalstore;

public class NewReleaseMovie implements MovieType {
    @Override
    public double getAmount(int dayRented) {
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
