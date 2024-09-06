package queue;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedParenthesisTest {

    @Test
    public void balanced() {
        BalancedParenthesis subject = new BalancedParenthesis();
        assertTrue(subject.balanced("{{}}[()](())"));
    }

    @Test
    public void unbalanced() {
        BalancedParenthesis subject = new BalancedParenthesis();
        assertFalse(subject.balanced("{{]}[[)](())"));
    }

}