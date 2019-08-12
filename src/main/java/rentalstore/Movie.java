package rentalstore;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    private MovieType movie;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        switch (priceCode) {
            case REGULAR:
                this.movie = new RegularMovie();
                break;
            case NEW_RELEASE:
                this.movie = new NewReleaseMovie();
                break;
            case CHILDRENS:
                this.movie = new ChildrenMovie();
        }
    }

    public double getRentalAmount(int dayRented) {
        return movie.getAmount(dayRented);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }
}
