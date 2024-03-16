package bit_manipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LonelyIntegerTest {

    private final LonelyInteger lonelyInteger = new LonelyInteger();

    @Test
    public void test() {
        int lonely = lonelyInteger.findLonely(new int[]{1, 2, 2, 1, 3, 4, 4, 5, 5});
        assertEquals(3, lonely);
    }
}
