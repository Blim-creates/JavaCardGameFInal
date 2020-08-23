package guessCardGame;
//Importing tools
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Black Jack game logic main class extending into JFram and including Action listeners
public class BlackJackGame extends JFrame implements ActionListener {

	//Creating variables for the game
    private Dealer deck;
    public Player player = new Player("player");
    public Player dealer = new Player("dealer");
    
    //Creating Buttons for the game
    private JButton jbtnHit = new JButton("Hit");
    private JButton jbtnStay = new JButton("Stay");
    private JButton jbtnDeal = new JButton("Deal");

    private JLabel jlblStatus = new JLabel(" ", JLabel.CENTER);

    //JPanel for Dealer space, Player space, Buttons, and Status space
    JPanel playerPanel = new JPanel();
    JPanel dealerPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JPanel statusPanel = new JPanel();

    //Creating window application for game
    BlackJackGame() {
        JFrame gameFrame = new JFrame("BlackJack");
        gameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("cards/10.png"));
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Adding buttons to panel
        buttonsPanel.add(jbtnHit);
        buttonsPanel.add(jbtnStay);
        buttonsPanel.add(jbtnDeal);
        statusPanel.add(jlblStatus);
        
        //Adding action listeners to button
        jbtnHit.addActionListener(this);
        jbtnStay.addActionListener(this);
        jbtnDeal.addActionListener(this);

        jbtnHit.setEnabled(false);
        jbtnStay.setEnabled(false);
        
        //setting panel background color
        dealerPanel.setBackground(Color.blue);
        playerPanel.setBackground(Color.blue);
        buttonsPanel.setBackground(Color.blue);
        statusPanel.setBackground(Color.blue);

        //Setting size of window and area of panel in window
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(dealerPanel, BorderLayout.NORTH);
        gameFrame.add(playerPanel, BorderLayout.CENTER);
        gameFrame.add(buttonsPanel, BorderLayout.SOUTH);
        gameFrame.add(statusPanel, BorderLayout.WEST);
        gameFrame.repaint();
        gameFrame.setSize(450, 350);
        gameFrame.setVisible(true);
    }
    
    //Method to hit player
    private void hitPlayer() {
        BlackJackCard newCard = player.dealTo(deck.dealFrom());
        playerPanel.add(new JLabel(new ImageIcon("cards/" + newCard.toString())));
        playerPanel.updateUI();
    }
    
    //Method to Hit Dealer Down
    private void hitDealerDown() {
    	BlackJackCard newCard = dealer.dealTo(deck.dealFrom());
        dealerPanel.add(new JLabel(new ImageIcon("cards/b2fv.png")));
        dealerPanel.updateUI();
    }

    //Method to hit Dealer
    private void hitDealer() {
    	BlackJackCard newCard = dealer.dealTo(deck.dealFrom());
        dealerPanel.add(new JLabel(new ImageIcon("cards/" + newCard.toString())));
        dealerPanel.updateUI();
    }

    //Method to Deal a new game
    private void deal() {
        playerPanel.removeAll();
        dealerPanel.removeAll();
        playerPanel.updateUI();
        dealerPanel.updateUI();
        player.reset();
        dealer.reset();
        if (deck == null || deck.size() < 15) {
            deck = new Dealer();
            deck.shuffle();
            jlblStatus.setText("Shuffling");
        }
        hitPlayer();
        hitDealerDown();
        hitPlayer();
        hitDealer();
    }

    //Game rules and will ouput game status
    private void checkWinner() {
        dealerPanel.removeAll();
        for (int i = 0; i < dealer.inHand(); i++) {
            dealerPanel.add(new JLabel(new ImageIcon("cards/" + dealer.cards[i].toString())));
        }
        if (player.value() > 21) {
            jlblStatus.setText("Player Loses");
        } else if (dealer.value() > 21) {
            jlblStatus.setText("Dealer Loses");
        } else if (dealer.value() == player.value()) {
            jlblStatus.setText("Push");
        } else if (dealer.value() < player.value()) {
            jlblStatus.setText("Player Wins");
        } else {
            jlblStatus.setText("Dealer Wins");
        }
    }

    //Action listener for hit player
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnHit) {
            hitPlayer();
            if (player.value() > 21) {
                checkWinner();
                jbtnHit.setEnabled(false);
                jbtnStay.setEnabled(false);
                jbtnDeal.setEnabled(true);
            }
        }

        if (e.getSource() == jbtnStay) {
            while (dealer.value() < 17 || player.value() > dealer.value()) {
                hitDealer();
            }
            checkWinner();
            jbtnHit.setEnabled(false);
            jbtnStay.setEnabled(false);
            jbtnDeal.setEnabled(true);
        }

        if (e.getSource() == jbtnDeal) {
            deal();
            jlblStatus.setText(" ");
            jbtnHit.setEnabled(true);
            jbtnStay.setEnabled(true);
            jbtnDeal.setEnabled(false);
        }
    }

//    public static void main(String[] args) {
//        new BlackJackGame();
//    }
}
