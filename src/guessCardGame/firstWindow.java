package guessCardGame;
//importing tools
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.IOException;
//creating the first window popup for user to select which game they want to play
public class firstWindow {
// Private variables for JFrame and Event listeners
	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstWindow window = new firstWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public firstWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Button to launch the guessing game
		JButton guessGame = new JButton("Guess Game");
		guessGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//System.out.println("hello");
			try {
				//Calling on the guessing game to launch
				new CardGuessingGame();
				frame.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		guessGame.setBounds(54, 178, 135, 56);
		frame.getContentPane().add(guessGame);
		
		//Button for user to play black jack
		JButton blackJack = new JButton("Black Jack");
		blackJack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calling for the blackjack game
				new BlackJackGame();
				frame.dispose(); //Closes main window once game is launched
			}
		});
		blackJack.setBounds(243, 178, 135, 56);
		frame.getContentPane().add(blackJack);
		
		//Button to view authorship
		JButton authorship = new JButton("Authorship");
		authorship.setAction(action);
		authorship.setBounds(243, 53, 135, 56);
		frame.getContentPane().add(authorship);
		
		//Button to view Black Jack game rules
		JButton BlackJackRules = new JButton("BlackJack Rules");
		BlackJackRules.setAction(action_1);
		BlackJackRules.setBounds(54, 53, 135, 56);
		frame.getContentPane().add(BlackJackRules);
	}
	//Event listener for authorship
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Authorship");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		//Dialog box to view authorship
		public void actionPerformed(ActionEvent e) {
			// create a dialog Box 
            JDialog d = new JDialog(frame, "Authorship"); 
  
            // create a label 
            JLabel l = new JLabel("<html><div style='text-align: center;'>" + "Class: IT 211 <br>" + "Card Game Project Final <br>" + "Created By: Brandon Lim <br>" + "Date: 08/23/2020 <br>" + "</div></html>");

            d.getContentPane().add(l); 
  
            // setsize of dialog 
            d.setSize(175, 175);
  
            // set visibility of dialog 
            d.setVisible(true); 
		}
	}
	//Event listener for Game rules
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "BlackJack Rules");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		//Dialog box for game rules
		public void actionPerformed(ActionEvent e) {
			 JDialog d = new JDialog(frame, "Game Rules"); 
			  
	            // create a label 
	            JLabel l = new JLabel("<html><div style='text-align: center;'>" + "Black Jack Game Rules: <br>" + "~Main goal is to reach 21 and beat Dealer <br>" + "~Click Hit to add a random card to your hand <br>" + "~Click Stay to end your Hand <br>" + "~Click Deal to play Again <br>" + "~Tip: Try not to bust and strategically play safe! <br>" + "</div></html>");

	            d.getContentPane().add(l); 
	  
	            // setsize of dialog 
	            d.setSize(200, 200);
	  
	            // set visibility of dialog 
	            d.setVisible(true); 
		}
	}
}
