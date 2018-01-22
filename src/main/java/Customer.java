import java.util.ArrayList;
import java.util.List;

public class Customer {

    private List<Rental> rentals = new ArrayList<>();

    public Euro getTotalCharge() {
        Euro result = new Euro(0.00);

        for (Rental rental : rentals) {
            result = result.plus(rental.getCharge());
        }
        return result;
    }

    public void rentMovie(Movie movie, int daysRented) {
        rentals.add(new Rental(movie, daysRented));
    }

    public String printStatement() {
        return printStatementDetail() + printStatementFooter();
    }

    public String printStatementFooter() {
        return "Gesamt: " + getTotalCharge().format() + "\n";
    }

    public String printStatementDetail() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result
                    .append("\t")
                    .append(rental.getMovieTitle())
                    .append("\t")
                    .append(rental.getCharge().format())
                    .append("\n");
        }
        return result.toString();
    }
}
