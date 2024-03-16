package inheritance_polymorphisim_encapsulation;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractDeck implements CardDeck {

    /**
     * Part 1
     * Create a FixedDeck implementation of CardDeck that represents a small deck with 8 cards
     * in a pre-selected order. After construction subsequent calls to draw should draw the top
     * card from the deck and return one card at a time, in the following order:
     * "3H", "4S", "AD", "5H", "7D", "6S", "JH", "JS"
     */

    private final List<String> cards;
    int lastDrawIndex = -1;

    public AbstractDeck(List<String> cards) {
        this.cards = cards;
    }

    public AbstractDeck(CardDeck deck) {
        List<String> cards = new ArrayList<>();
        String card = deck.draw();
        while (card != null) {
            cards.add(card);
            card = deck.draw();
        }
        this.cards = cards;
    }

    public String draw() {
        if (lastDrawIndex >= cards.size() - 1) {
            return null;
        } else {
            lastDrawIndex++;
            return cards.get(lastDrawIndex);
        }
    }
}
