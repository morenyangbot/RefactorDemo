package rentalstore;

public class HtmlStatement {

    public String statement(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String header = getHeader(customer);
        StringBuilder result = new StringBuilder();
        result.append(header);
        for (Rental each : customer.getRentals()) {
            double thisAmount = each.getRentalAmount();

            frequentRenterPoints += each.getFrequentRenterPoints();

            String getRentalItem = getRentalItem(each, thisAmount);
            result.append(getRentalItem);
            totalAmount += thisAmount;
        }

        String footer = getFooter(totalAmount, frequentRenterPoints);
        result.append(footer);
        return result.toString();
    }

    private String getHeader(Customer customer) {
        return "<H1>Rental Record for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        String footer = "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM><P>\n";
        footer += "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints) + "</EM> frequent renter points<P>";
        return footer;
    }

    private String getRentalItem(Rental each, double thisAmount) {
        return each.getMovie().getTitle() + ": " + String.valueOf(thisAmount) + "<BR>\n";
    }
}
