package rentalstore;

public class ChildrenMovie implements MovieType{
    @Override
    public double getAmount(int dayRented) {
        double amount = 1.5;
        if (dayRented > 3) {
            amount += (dayRented - 3) * 1.5;
        }
        return amount;
    }
}
