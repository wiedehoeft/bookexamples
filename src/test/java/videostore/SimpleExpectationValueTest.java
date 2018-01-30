package videostore;

import org.junit.Before;
import org.junit.Test;

public class SimpleExpectationValueTest {

    private SimpleExpectationValue value;

    @Before
    public void setUp() {
        value = new SimpleExpectationValue("expectation value");
    }

    @Test
    public void testExpectedValue() {
        value.setExpected("Night on Earth");
        value.setActual("Night on Earth");
        value.verify();
    }

    @Test(expected = AssertionError.class)
    public void testWrongValue() {
        value.setExpected("Stranger than Paradise");
        value.setActual("Down by Law");
    }

    @Test(expected = AssertionError.class)
    public void testNoValue() {
        value.setExpected("Dead Man");
        value.verify();
    }
}