package guessCardGame;

//Creating the BlackJack Deck
public class BlackJackDeck {

	//Setting the size of the deck
    final static int DECK_SIZE = 52;
    public BlackJackCard[] cards; //Array of cards
    public int N = 0;

    //Method creating the Deck Suits and Ranks
    public BlackJackDeck() {
        cards = new BlackJackCard[DECK_SIZE];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[N] = new BlackJackCard(N, j, i + "" + j + ".png"); //Path file to view cards
                N++;
            }
        }
    }

//    public BlackJackCard dealFrom() {
//        return cards[--N];
//    }
//
//    public boolean isEmpty() {
//        return (N == 0);
//    }
//
//    public int size() {
//        return N;
//    }
//
//    public void shuffle() {
//        for (int i = 0; i < N; i++) {
//            int r = (int) (Math.random() * i);
//            BlackJackCard swap = cards[i];
//            cards[i] = cards[r];
//            cards[r] = swap;
//        }
//    }
}
