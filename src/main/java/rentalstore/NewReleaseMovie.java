package rentalstore;

public class NewReleaseMovie implements MovieType {
    @Override
    public double getAmount(int dayRented) {
        return dayRented * 3;
    }
}
