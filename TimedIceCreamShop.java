import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Xiaofan Xu
 * The class extends the IceCreamShop class. 
 * The difference is that the TimedIceCreamShop class can create an ice-cream to be served at a certain interval automatically
 * The player builds the next order, then is able to "serve" it to the next in line. 
 * At this point, the order should be checked if it is correct. 
 * If so, points are awarded to the player; if the order is incorrect, points are subtracted.
 * Also, every cone that has not been made before time up, you'll lose 5 points for each cone.
 * The player can also press the AddRandomOrder button to earn more points
 */
public class TimedIceCreamShop extends IceCreamShop implements ActionListener{

	public final int GAME_TIME = 20000;
	public final int TIME_FOR_NEW_ORDER = 5000;
	private JLabel timeRemainingLabel;
	private int timeRemaining;
	private Timer gameTimer;
	
	/**
	 * Constructor: Create the super class and set up default settings
	 */
	public TimedIceCreamShop(){
		super();
		timeRemaining = GAME_TIME + TIME_FOR_NEW_ORDER;
		timeRemainingLabel = new JLabel("Time remaining: " + (timeRemaining-TIME_FOR_NEW_ORDER)/1000 + "s.");
		add(timeRemainingLabel, BorderLayout.SOUTH);
		createTimer();
	}
	
	/**
	 * Create and define Timer 
	 */
	private void createTimer(){
		ActionListener taskPerformed = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				line.addRandomOrder();
				timeRemaining = timeRemaining - TIME_FOR_NEW_ORDER;
				
				//Summarize the total points after time up
				 if (timeRemaining == 0) {
					 gameTimer.stop();
					 if (line.hasOrder()==true){
						 int i = 0;
						 while (line.hasOrder()==true) {
							 line.getNextOrder();
							 i++;
						 }
						 score += (i-1)*INCORRECT_MATCH_SCORE;
						 updateScore();
						 repaint();
						 
						 //Disable the game
						 addOrderArea().setVisible(false);
						 JPanel blank = new JPanel();
						 add(blank, BorderLayout.WEST);
					 }
			     }
				 updateTimerLabel();
				 
			}
		};
	
		
		gameTimer = new Timer(TIME_FOR_NEW_ORDER, taskPerformed);
		
		gameTimer.start();
	
	    setVisible(true);
	}
	
	/**
	 * Update the text of the timeRemainingLabel
	 */
	private void updateTimerLabel(){
		timeRemainingLabel.setText("Time remaining: " + timeRemaining/1000 + "s.");
	}
	
	/**
	 * Override the addControls() class in the super class
	 */
	protected void addControls(){
		
		scoreLabel = new JLabel(" Score: " + score);
		JLabel INSTRUCTIONS1 = new JLabel(" Make ice cream cones to match the next order ( at the top).");
		JLabel INSTRUCTIONS2 = new JLabel(" Every correct order served earns you 10 points.");
		JLabel INSTRUCTIONS3 = new JLabel(" Make the wrong cone and you'll lose 5 points.");
		JLabel INSTRUCTIONS4 = new JLabel(" Every cone that has not been made before time up, you'll lose 5 points for each cone.");
		
		JPanel panelControls = new JPanel();
		panelControls.setLayout(new GridLayout(6, 1));
		panelControls.add(INSTRUCTIONS1);
		panelControls.add(INSTRUCTIONS2);
		panelControls.add(INSTRUCTIONS3);
		panelControls.add(INSTRUCTIONS4);
		panelControls.add(scoreLabel);
		panelControls.add(createServeNext());
		add(panelControls, BorderLayout.NORTH);
	}
	
}
