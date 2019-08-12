package rentalstore;

import java.util.stream.Collectors;

public abstract class Statement {
    public String statement(Customer customer) {
        double totalAmount = customer.getTotalAmount();
        int frequentRenterPoints = customer.getTotalFrequentRenterPoints();
        return getHeader(customer) +
                getRentalItemsSting(customer) +
                getFooter(totalAmount, frequentRenterPoints);
    }

    private String getRentalItemsSting(Customer customer) {
        return customer.getRentals().stream()
                .map(rental -> getRentalItem(rental, rental.getRentalAmount()))
                .collect(Collectors.joining());
    }

    protected abstract String getFooter(double totalAmount, int frequentRenterPoints);

    protected abstract String getRentalItem(Rental rental, double thisAmount);

    protected abstract String getHeader(Customer customer);

}
