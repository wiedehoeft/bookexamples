import static org.junit.Assert.assertEquals;

public class SimpleExpectationValue {
    private String name;
    private Object expected;
    private Object actual;

    public SimpleExpectationValue(String name) {
        this.name = name;
    }

    public void setExpected(Object expected) {
        this.expected = expected;
    }

    public void setActual(Object actual) {
        this.actual = actual;
        verify();
    }

    public void verify() {
        assertEquals(name + "did not receive the expecteed value \n", expected, actual);
    }
}