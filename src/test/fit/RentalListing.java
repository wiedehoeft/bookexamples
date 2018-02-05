import fit.RowFixture;
import videostore.RentalItem;
import videostore.VideoStore;

public class RentalListing extends RowFixture {
  private VideoStore store = SystemUnderTest.instance();

  @Override
  public Object[] query() throws Exception {
    return store.allRentalItems().toArray();
  }

  @Override
  public Class getTargetClass() {
    return RentalItem.class;
  }
}
