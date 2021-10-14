package inheritance_polymorphisim_encapsulation;

public class PeekDeck extends AbstractDeck {

  /**
   *  Part 2
   *  Create a PeekDeck implementation of CardDeck that has an additional method "peek".
   *  PeekDeck should take an existing CardDeck in its constructor. The peek method should
   *  allow you to look at the top card of the deck without drawing it.
   *  Subsequently calling draw should return the same card that peek just returned.
   */

  private String peekedCard = null;

  public PeekDeck(CardDeck deck) {
    super(deck);
  }

  public String peek() {
    if (peekedCard == null) {
      peekedCard = super.draw();
    }
    return peekedCard;
  }

  public String draw() {
    if (peekedCard != null) {
      String card = peekedCard;
      peekedCard = null;
      return card;
    } else {
      return super.draw();
    }
  }
}
