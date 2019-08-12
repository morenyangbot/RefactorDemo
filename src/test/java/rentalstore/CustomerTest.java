package rentalstore;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer = new Customer("A");

    @Test
    public void testStatement_givenNoRentals_thenReturnAmount0AndPoint0() {
        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", statement);
    }

    @Test
    public void testStatement_givenRegularTypeAndDayRented1_thenReturnAmount2AndPoint1() {
        Movie regularMovie = new RegularMovie("Title1");
        int dayRented = 1;
        Rental regularRental = new Rental(regularMovie, dayRented);
        customer.addRental(regularRental);

        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "\tTitle1\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void testStatement_givenRegularTypeAndDayRented3_thenReturnAmount3_5AndPoint1() {
        Movie regularMovie = new RegularMovie("Title1");
        int dayRented = 3;
        Rental regularRental = new Rental(regularMovie, dayRented);
        customer.addRental(regularRental);

        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "\tTitle1\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void testStatement_givenNewReleaseTypeAndDayRented1_thenReturnReturnAmount3AndPoint1() {
        Movie newReleaseMovie = new NewReleaseMovie("Title2");
        int dayRented = 1;
        Rental newReleaseRental = new Rental(newReleaseMovie, dayRented);
        customer.addRental(newReleaseRental);

        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "\tTitle2\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void testStatement_givenNewReleaseTypeAndDayRented2_thenReturnReturnAmount6AndPoint2() {
        Movie newReleaseMovie = new NewReleaseMovie("Title2");
        int dayRented = 2;
        Rental newReleaseRental = new Rental(newReleaseMovie, dayRented);
        customer.addRental(newReleaseRental);

        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "\tTitle2\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void testStatement_givenChildrenTypeAndDayRented2_thenReturnReturnAmount1_5AndPoint1() {
        Movie childrenMovie = new ChildrenMovie("Title3");
        int dayRented = 2;
        Rental childrenRental = new Rental(childrenMovie, dayRented);
        customer.addRental(childrenRental);

        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "\tTitle3\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void testStatement_givenChildrenTypeAndDayRented3_thenReturnReturnAmount3AndPoint1() {
        Movie childrenMovie = new ChildrenMovie("Title3");
        int dayRented = 4;
        Rental childrenRental = new Rental(childrenMovie, dayRented);
        customer.addRental(childrenRental);

        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "\tTitle3\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void testStatement_givenTwoDented_thenReturnCorrectAmountAndPoints() {
        Movie childrenMovie = new ChildrenMovie("Title3");
        Movie regularMovie = new RegularMovie("Title1");
        int dayRented = 4;
        Rental childrenRental = new Rental(childrenMovie, dayRented);
        Rental regularRental = new Rental(regularMovie, dayRented);
        customer.addRental(childrenRental);
        customer.addRental(regularRental);

        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "\tTitle3\t3.0\n" +
                "\tTitle1\t5.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void testHtmlStatement_givenNoRentals_thenReturnAmount0AndPoint0() {
        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>A</EM></H1><P>\n" +
                "<P>You owe<EM>0.0</EM><P>\n" +
                "On this rental you earned <EM>0</EM> frequent renter points<P>", statement);
    }

    @Test
    public void testHtmlStatement_givenRegularTypeAndDayRented1_thenReturnAmount2AndPoint1() {
        Movie regularMovie = new RegularMovie("Title1");
        int dayRented = 1;
        Rental regularRental = new Rental(regularMovie, dayRented);
        customer.addRental(regularRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>A</EM></H1><P>\n" +
                "Title1: 2.0<BR>\n" +
                "<P>You owe<EM>2.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void testHtmlStatement_givenTwoDented_thenReturnCorrectAmountAndPoints() {
        Movie childrenMovie = new ChildrenMovie("Title3");
        Movie regularMovie = new RegularMovie("Title1");
        int dayRented = 4;
        Rental childrenRental = new Rental(childrenMovie, dayRented);
        Rental regularRental = new Rental(regularMovie, dayRented);
        customer.addRental(childrenRental);
        customer.addRental(regularRental);

        String statement = customer.htmlStatement();

        assertEquals("<H1>Rental Record for <EM>A</EM></H1><P>\n" +
                "Title3: 3.0<BR>\n" +
                "Title1: 5.0<BR>\n" +
                "<P>You owe<EM>8.0</EM><P>\n" +
                "On this rental you earned <EM>2</EM> frequent renter points<P>", statement);
    }
}