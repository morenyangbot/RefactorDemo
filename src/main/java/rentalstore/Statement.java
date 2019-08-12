package rentalstore;

public abstract class Statement {
    public String statement(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();
        String getHeader = getHeader(customer);
        result.append(getHeader);
        for (Rental each : customer.getRentals()) {
            double thisAmount = each.getRentalAmount();
            frequentRenterPoints += each.getFrequentRenterPoints();

            result.append(getRentalItem(each, thisAmount));
            totalAmount += thisAmount;
        }
        String footer = getFooter(totalAmount, frequentRenterPoints);

        result.append(footer);
        return result.toString();
    }

    protected abstract String getFooter(double totalAmount, int frequentRenterPoints);

    protected abstract String getRentalItem(Rental rental, double thisAmount);

    protected abstract String getHeader(Customer customer);


}
