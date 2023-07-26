public class Card {
    enum Suit { HEARTS, SPADES, DIAMONDS, CLUBS }
    enum Rank { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }
    private Suit suit;
    private Rank rank;

    public Card(Suit s, Rank r)
    {
        suit = s;
        rank = r;
    }

    @Override
    public String toString()
    {
        return suit + " " + rank;
    }

}
