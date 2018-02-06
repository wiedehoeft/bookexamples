import fit.Fixture;
import fit.Parse;
import videostore.Movie;
import videostore.VideoStore;

import java.util.List;

public class Exactly extends Fixture {

  private VideoStore store = SystemUnderTest.instance();
  private List<Movie> movies;

  @Override
  public void doCell(Parse parse, int i) {
    String searchString = parse.text();
    movies = store.searchMovies(searchString);
  }

  @Override
  public void doCells(Parse cells) {
    super.doCells(cells);

    for (Movie movie : movies) {
      appendCellTo(cells, movie.getTitle());
      right(cells);
    }
  }

  private void appendCellTo(Parse cells, String body) {
    cells.last().more = new Parse("td", body, null, null);
  }

  @Override
  public void doRow(Parse row) {
    super.doRow(row);
    if (movies.isEmpty()) {
      markRowWithNoMatch(row);
    }
  }

  private void markRowWithNoMatch(Parse row) {
    Parse cell = row.leaf();
    cell.addToTag(" style=\"font-style:italic;\"");
    cell.addToBody(" no match");
  }

  /**
   * Ignore second column header
   *
   * @param table
   */
  @Override
  public void doTable(Parse table) {
    doRow(table.parts.more.more);
  }
}