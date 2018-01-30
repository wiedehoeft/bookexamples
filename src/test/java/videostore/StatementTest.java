package videostore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class StatementTest {

  @Mock
  private IStatement statement;

  @Mock
  private IRental rental;

  @Mock
  private IPrice price;

  @Mock
  private IPrinter printer;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCustomer() throws Exception {

    // Given
    Customer customer = new Customer("Zing Zang Zong");

    //When
    customer.addRental(rental);
    customer.printOn(statement);

    //Then
    verify(rental).printOn(statement);
    verify(statement).printCustomerName("Zing Zang Zong");
    verify(statement).printTotalCharge();
  }

  @Test
  public void testRental() throws Exception {

    // Given
    Rental rental = new Rental("Amelie", price, 1);

    //When
    rental.printOn(statement);

    //Then
    verify(statement).printMovieTitle("Amelie");
    verify(price).printOn(statement, 1);
  }

  @Test
  public void testBasePrice() throws OutOfPaperException {
    verifyPrice(1.50, 1);
    verifyPrice(1.50, 3);
  }

  @Test
  public void testIncrementalPrice() throws OutOfPaperException {
    verifyPrice(3.00, 4);
    verifyPrice(7.50, 7);
  }

  private void verifyPrice(double charge, int daysRented) throws OutOfPaperException {
    new Price().printOn(statement, daysRented);
    verify(statement).printMovieCharge(new Euro(charge));
  }

  @Test
  public void testStatement() throws Exception {

    // Given
    Statement statement = new Statement(printer);

    //When
    statement.printCustomerName("Zing Zang Zong");
    statement.printMovieTitle("Bladerunner");
    statement.printMovieCharge(new Euro(1.50));
    statement.printMovieTitle("Taxi Driver");
    statement.printMovieCharge(new Euro(4.50));
    statement.printTotalCharge();

    //Then
    InOrder inOrder = Mockito.inOrder(printer);
    inOrder.verify(printer).print("videostore.Rental records for Zing Zang Zong");
    inOrder.verify(printer).crlf();
    inOrder.verify(printer).tab();
    inOrder.verify(printer).print("Bladerunner");
    inOrder.verify(printer).tab();
    inOrder.verify(printer).print("1,50");
    inOrder.verify(printer).crlf();
    inOrder.verify(printer).tab();
    inOrder.verify(printer).print("Taxi Driver");
    inOrder.verify(printer).tab();
    inOrder.verify(printer).print("4,50");
    inOrder.verify(printer).crlf();
    inOrder.verify(printer).print("Amount owed is 6,00");
    inOrder.verify(printer).crlf();
    inOrder.verify(printer).cutPaper();
  }
}
