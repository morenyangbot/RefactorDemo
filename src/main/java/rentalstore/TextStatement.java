package rentalstore;

public class TextStatement {
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

    private String getRentalItem(Rental each, double thisAmount) {
        return "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        String footer = "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + frequentRenterPoints + " frequent renter points";
        return footer;
    }

    private String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
