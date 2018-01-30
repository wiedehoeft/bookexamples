package videostore;

public class Printer implements IPrinter {
  @Override
  public void print(String line) {
    System.out.println(line);
  }

  @Override
  public void tab() {
    System.out.println("\t");
  }

  @Override
  public void crlf() {
    System.out.println("\n");
  }

  @Override
  public void cutPaper() {

  }
}
