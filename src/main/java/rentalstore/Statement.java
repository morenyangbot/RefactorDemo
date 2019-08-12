package rentalstore;

public abstract class Statement {
    public String statement(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();
        result.append(getHeader(customer));
        for (Rental rental : customer.getRentals()) {
            double thisAmount = rental.getRentalAmount();
            frequentRenterPoints += rental.getFrequentRenterPoints();
            result.append(getRentalItem(rental, thisAmount));
            totalAmount += thisAmount;
        }

        result.append(getFooter(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    protected abstract String getFooter(double totalAmount, int frequentRenterPoints);

    protected abstract String getRentalItem(Rental rental, double thisAmount);

    protected abstract String getHeader(Customer customer);


}
