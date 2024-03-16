package inheritance_polymorphisim_encapsulation;

import java.util.ArrayList;
import java.util.List;

public class CloneDeck implements CardDeck {

    /**
     * Part 3
     * Create a CloneDeck implementation of CardDeck that has an additional method "clone".
     * CloneDeck should take an existing CardDeck in its constructor. Clone should return a
     * CloneDeck which represents a clone of the underlying deck at the point in time it was cloned.
     * After cloning, calls to draw on the original and cloned CardDeck should return an identical
     * sequence of cards.
     */

    private final List<String> cards = new ArrayList<>();

    public CloneDeck(CardDeck deck) {
        String card = deck.draw();
        while (card != null) {
            cards.add(card);
            card = deck.draw();
        }
    }

    public CloneDeck clone() {
        return new CloneDeck(new FixedDeck(cards));
    }

    public String draw() {
        if (cards.size() == 0) {
            return null;
        } else {
            String drawnCard = cards.get(0);
            cards.remove(drawnCard);
            return drawnCard;
        }
    }
}
