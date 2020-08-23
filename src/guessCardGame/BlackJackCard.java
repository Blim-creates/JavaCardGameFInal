package guessCardGame;

//Card Class
public class BlackJackCard {

    private int cardNumber;
    private int rank;
    private String front;
    
    //Method to define card number, rank, and front
    BlackJackCard(int cardNumber, int rank, String front) {
        this.cardNumber = cardNumber;
        this.rank = rank;
        this.front = front;
    }

    //Boolean for ACE
    public boolean isAce() {
        return rank == 0;
    }

    //Ranking
    public int rank() {
        if (rank == 0) {
            return 1;
        }
        if (rank >= 9) {
            return 10;
        }
        return rank + 1;
    }

    //String of card
    public String toString() {
        return this.front;
    }
}
