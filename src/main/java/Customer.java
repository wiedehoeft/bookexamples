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

    public String printStatementFooter() {
        return "Gesamt: " + getTotalCharge().format() + "\n";
    }

    public void printStatementDetail(IPrinter printer) throws OutOfPaperException {
        for (Rental rental : rentals) {
            printer.tab();
            printer.print(rental.getMovieTitle());
            printer.tab();
            printer.print(rental.getCharge().format());
            printer.crlf();
        }
        printer.cutPaper();
    }
}
