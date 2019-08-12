package rentalstore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String statement() {
        return new TextStatement().statement(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().statement(this);
    }

    double getTotalAmount() {
        return getRentals()
                .stream()
                .mapToDouble(Rental::getRentalAmount)
                .sum();
    }

    int getTotalFrequentRenterPoints() {
        return getRentals()
                .stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }
}
