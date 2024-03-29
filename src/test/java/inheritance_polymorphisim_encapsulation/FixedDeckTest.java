package inheritance_polymorphisim_encapsulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FixedDeckTest {
    List<String> cards;

    @BeforeEach
    public void setUp() {
        cards = new ArrayList<>();
        cards.add("3H");
        cards.add("4S");
    }

    @Test
    public void fixed_deck_draws_the_next_card() {
        assertDraw(new FixedDeck(cards));
    }

    @Test
    public void peek_deck_peeks_card() {
        PeekDeck cardDeck = new PeekDeck(new FixedDeck(cards));
        assertEquals("3H", cardDeck.peek());
        assertEquals("3H", cardDeck.peek());
        assertDraw(cardDeck);
    }

    @Test
    public void cloned_deck_draws() {
        CloneDeck cloneDeck = new CloneDeck(new FixedDeck(cards));
        assertDraw(cloneDeck);
    }

    @Test
    public void cloned_deck_resumes_draw() {
        CloneDeck cloneDeckA = new CloneDeck(new FixedDeck(cards));
        String card = cloneDeckA.draw();
        assertEquals("3H", card);

        CloneDeck cloneDeckB = cloneDeckA.clone();

        card = cloneDeckA.draw();
        assertEquals("4S", card);
        card = cloneDeckA.draw();
        assertNull(card);

        card = cloneDeckB.draw();
        assertEquals("4S", card);
        card = cloneDeckB.draw();
        assertNull(card);
    }

    private void assertDraw(CardDeck cardDeck) {
        String card;
        card = cardDeck.draw();
        assertEquals("3H", card);
        card = cardDeck.draw();
        assertEquals("4S", card);
        card = cardDeck.draw();
        assertNull(card);
        card = cardDeck.draw();
        assertNull(card);
    }
}
