package videostore;

public class Main {
  public static void main(String[] args) {

    VideoStore videoStore = VideoStore.bindCustomer("Hugo");

    videoStore.rentMovie("Pulp fiction", 4);
    videoStore.printStatement();
  }
}
