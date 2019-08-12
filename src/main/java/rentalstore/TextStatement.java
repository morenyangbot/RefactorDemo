package rentalstore;

public class TextStatement extends Statement {


    protected String getRentalItem(Rental each, double thisAmount) {
        return "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

    protected String getFooter(double totalAmount, int frequentRenterPoints) {
        String footer = "Amount owed is " + totalAmount + "\n";
        footer += "You earned " + frequentRenterPoints + " frequent renter points";
        return footer;
    }

    protected String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
