import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class CardDeck implements Iterable<Card>{
    private static CardDeck cardDeck = null;
    private List<Card> cards;

    private CardDeck(){
        cards = new LinkedList<>();
        this.fillDeck();
    }

    public static CardDeck getInstance(){
        if(cardDeck == null)
            cardDeck = new CardDeck();
        return cardDeck;
    }

    public void fillDeck(){
        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Rank rank: Card.Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public int size(){
        return cards.size();
    }

    public Card takeCard(int i){
        return cards.remove(i);
    }

    public List<Card> getCards(){
        return cards;
    }

    @Override
    public Iterator<Card> iterator() {
        return new CardIterator((Card[]) cards.toArray());
    }
}
