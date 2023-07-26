import java.util.Iterator;

public class CardIterator implements Iterator<Card> {
    private Card[] list;
    private int nextIndex = 0;
    private int lastIndex = -1;

    public CardIterator (Card[] cardArray)
    {
        list = cardArray;
    }

    public boolean hasNext ()
    {
        return nextIndex != list.length;
    }

    public Card next ()
    {
        lastIndex = nextIndex;
        nextIndex++;

        return list[lastIndex];
    }
}
