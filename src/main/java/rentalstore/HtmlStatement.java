package rentalstore;

public class HtmlStatement extends Statement {


    protected String getHeader(Customer customer) {
        return "<H1>Rental Record for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }

    protected String getFooter(double totalAmount, int frequentRenterPoints) {
        String footer = "<P>You owe<EM>" + totalAmount + "</EM><P>\n";
        footer += "On this rental you earned <EM>" + frequentRenterPoints + "</EM> frequent renter points<P>";
        return footer;
    }

    protected String getRentalItem(Rental each, double thisAmount) {
        return each.getMovie().getTitle() + ": " + thisAmount + "<BR>\n";
    }
}
