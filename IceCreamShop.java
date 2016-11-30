import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Xiaofan Xu
 * The class builds off of the queue-based IceCreamLine as well as the stack-based IceCreamMaker. 
 * This IceCreamShop game has an order queue; 
 * The player builds the next order, then is able to "serve" it to the next in line. 
 * At this point, the order should be checked if it is correct. 
 * If so, points are awarded to the player; 
 * if the order is incorrect, points are subtracted.
 */
public class IceCreamShop extends JPanel implements ActionListener{
	public final int CORRECT_MATCH_SCORE = 10;
	public final int INCORRECT_MATCH_SCORE = -5;
	protected IceCreamLine line;
	private IceCreamMaker maker;
	protected int score;
	protected JLabel scoreLabel;
	
	/**
	 * Constructor: set BorderLayout & default settings as well as Initiate variables 
	 */
	public IceCreamShop(){
		super(new BorderLayout());
		line = new IceCreamLine();
		maker = new IceCreamMaker();
		score = 0;
		
		add(maker, BorderLayout.CENTER);
		addControls();
		addOrderArea();
	}
	
	/**
	 * Create a Jpanel for addOrderArea
	 * @return JPanel that contains the line and the addOrder Button
	 */
	protected JPanel addOrderArea(){
		JButton addOrder= new JButton("Add a random order");
		addOrder.setPreferredSize(new Dimension(150,50));
		addOrder.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				line.addRandomOrder();
			}
		});
		 
		JPanel panelOrderArea = new JPanel();
		panelOrderArea.setLayout(new GridLayout(2, 1));
		panelOrderArea.add(line);
		panelOrderArea.add(addOrder);
		add(panelOrderArea, BorderLayout.WEST);
		
		return panelOrderArea;
	}
	
	/**
	 * Add Instructions, scoreLabel and serveNext Button to a panel which is on the north of the JFrame
	 */
	protected void addControls(){
		
		scoreLabel = new JLabel(" Score: " + score);
		JLabel INSTRUCTIONS1 = new JLabel(" Make ice cream cones to match the next order ( at the top).");
		JLabel INSTRUCTIONS2 = new JLabel(" Every correct order served earns you 10 points.");
		JLabel INSTRUCTIONS3 = new JLabel(" Make the wrong cone and you'll lose 5 points.");
		
		JPanel panelControls = new JPanel();
		panelControls.setLayout(new GridLayout(5, 1));
		panelControls.add(INSTRUCTIONS1);
		panelControls.add(INSTRUCTIONS2);
		panelControls.add(INSTRUCTIONS3);
		panelControls.add(scoreLabel);
		panelControls.add(createServeNext());
		add(panelControls, BorderLayout.NORTH);
	}
	
	/**
	 * Delete the one which has been already served 
	 * @return JPanel: panelServeNext which contains serveNext Button
	 */
	protected JPanel createServeNext(){		
		JPanel panelServeNext = new JPanel();
		panelServeNext.setLayout(new GridLayout(1, 1));
		
		JButton serveNext= new JButton("Serve the next order");
		
		serveNext.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == serveNext ){
					IceCreamCone c1;
					IceCreamCone c2;
					c1 = line.getNextOrder();
					c2 = maker.coneGetter();
					if (c1 != null && c2 !=null){
						if (matches(c1,c2) == true) {
							score += CORRECT_MATCH_SCORE;
						}
						else{
							score += INCORRECT_MATCH_SCORE;
						}
					}
					repaint();
					updateScore();
				}
			}
				
		}); 
		
		panelServeNext.add(serveNext);
		return panelServeNext;
		
	}
	
	/**
	 * Update the text in the scoreLabel
	 */
	protected void updateScore(){
		scoreLabel.setText(" Score: " + score);
		scoreLabel.repaint();
	}
	
	/**
	 * Pop the two input stacks to compare each scoop
	 * @param c1 the IceCreamCone that should be served
	 * @param c2 the IceCreamCone that the player has made
	 * @return true, if c1 and c2 are identical 
	 */
	private boolean matches(IceCreamCone c1, IceCreamCone c2){
			while (c1.getScoopFlavorStack().isEmpty()==false && c2.getScoopFlavorStack().isEmpty()==false){
				if (c1.PopTopScoop() != c2.PopTopScoop()){
					return false;
				}
			}
			return true;
	}
	
	/**
	 * Method from ActionListner interface
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
