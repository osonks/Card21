import java.util.*;

public class Magician  {
    private CardDeck cardDeck;
    private Stack<Card> deckSubset;
    private Queue<Card> column1;
    private Queue<Card> column2;
    private Queue<Card> column3;
    private List<Queue> order;
    private int round;

    public Magician(){
        cardDeck = CardDeck.getInstance();
        deckSubset = new Stack<>();
        column1 = new LinkedList<>();
        column2 = new LinkedList<>();
        column3 = new LinkedList<>();
        order = new LinkedList<>();
        order.add(column1);
        order.add(column2);
        order.add(column3);
        round=0;
    }

    public void pick21cards(){
        Collections.shuffle(cardDeck.getCards());
        for(int i=0; i<21; i++) {
            deckSubset.push(cardDeck.takeCard(0));
        }
    }

    public String show21Cards(){
        String s="";
        for(Card card: deckSubset){
            s+= (card + "\n");
        }
        return s;
    }

    public void distributeCards(){
        for(int i=0; i<7; i++){
            column1.add(deckSubset.pop());
            column2.add(deckSubset.pop());
            column3.add(deckSubset.pop());
        }
    }

    public String showColumns(){
        String s="";

        s+="\n(1)\n";
        for (Card card: column1){
            s+=(card + "\n");
        }

        s+="\n(2)\n";
        for (Card card: column2){
            s+=(card + "\n");
        }

        s+="\n(3)\n";
        for (Card card: column3){
            s+=(card + "\n");
        }
        s+="\n";

        return s;
    }

    public Queue<Card> getColumn(int i){
        if(i==1)return column1;
        if(i==2)return column2;
        else return column3;
    }

    public void collectCards(int i){
        // to put the column that contains the card in the middle
        Queue<Card> playersColumn = getColumn(i);
        order.remove(playersColumn);
        order.add(1,playersColumn);

        // return all the columns to the subset
        Queue<Card> currentColumn;

        for(int j=0;j<order.size();j++){
            currentColumn = order.get(j);

            while (!currentColumn.isEmpty()){
                deckSubset.push(currentColumn.remove());
            }
        }
        round++;
    }

    public String revealChosenCard(){
        if(round != 3)
            return "I Cannot reveal the chosen card yet !\n";

        else return "Your cards is: " + deckSubset.get(10) + " !! :D\n";
    }

}
