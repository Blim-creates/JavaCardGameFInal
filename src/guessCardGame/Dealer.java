package guessCardGame;


//Using class inheritance to create a dealer class
public class Dealer extends BlackJackDeck {
	
	//Dealing cards
		public BlackJackCard dealFrom() {
	        return cards[--N];
	    }
		//Checking to see if the deck is empty
	    public boolean isEmpty() {
	        return (N == 0);
	    }
	    //Size of Hand
	    public int size() {
	        return N;
	    }
	    
	    //Shuffling the deck
	    public void shuffle() {
	        for (int i = 0; i < N; i++) {
	            int r = (int) (Math.random() * i);
	            BlackJackCard swap = cards[i];
	            cards[i] = cards[r];
	            cards[r] = swap;
	        }
	    }
}
