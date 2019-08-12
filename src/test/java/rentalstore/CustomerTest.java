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
        Movie regularMovie = new Movie("Title1", Movie.REGULAR);
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
        Movie regularMovie = new Movie("Title1", Movie.REGULAR);
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
        Movie newReleaseMovie = new Movie("Title2", Movie.NEW_RELEASE);
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
        Movie newReleaseMovie = new Movie("Title2", Movie.NEW_RELEASE);
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
        Movie childrenMovie = new Movie("Title3", Movie.CHILDRENS);
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
        Movie childrenMovie = new Movie("Title3", Movie.CHILDRENS);
        int dayRented = 4;
        Rental childrenRental = new Rental(childrenMovie, dayRented);
        customer.addRental(childrenRental);

        String statement = customer.statement();

        assertEquals("Rental Record for A\n" +
                "\tTitle3\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }
}