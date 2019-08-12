package rentalstore;

public interface MovieType {
    double getAmount(int dayRented);

    int getFrequentRenterPoints(int getDayRented);
}
