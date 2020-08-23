package guessCardGame;

//Player class for Black Jack
public class Player {

	//Deck of cards
    final static int MAX_CARDS = 52;
    public BlackJackCard[] cards = new BlackJackCard[MAX_CARDS];
    private int N = 0;
    private String name;

    //Player name
    public Player(String name) {
        this.name = name;
    }

    //Player Hand
    public int inHand() {
        return N;
    }

    //Player Deal
    public BlackJackCard dealTo(BlackJackCard c) {
        cards[N++] = c;
        return c;
    }

    //Reset hand
    public void reset() {
        N = 0;
    }

    //Creating the Value of Ace using if statements 
    public int value() {
        int val = 0;
        boolean hasAce = false;
        for (int i = 0; i < N; i++) {
            val = val + cards[i].rank();
            if (cards[i].isAce()) {
                hasAce = true;
            }
        }
        if (hasAce && (val <= 11)) {
            val = val + 10;
        }
        return val;
    }
}
