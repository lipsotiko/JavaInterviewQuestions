package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumDigitsTest {

    SumDigits sd = new SumDigits();

    @Test
    public void test_1() {
        assertEquals(10, sd.sum(55));
    }

    @Test
    public void test_2() {
        assertEquals(13, sd.sum(58));
    }
}
