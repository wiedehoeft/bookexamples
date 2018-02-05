import videostore.VideoStore;

public class SystemUnderTest {
  private static VideoStore instance = new VideoStore();

  public static VideoStore instance() {
    return instance;
  }

  public static void reset() {
    instance = new VideoStore();
  }
}
