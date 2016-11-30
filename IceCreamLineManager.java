import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Xiaofan Xu
 * Test IceCreamLine by creating a GUI application offering buttons 
 * To add a random order to the line or remove the first order. 
 */
public class IceCreamLineManager extends JPanel implements ActionListener{

	private IceCreamLine line;
	
	/**
	 * Constructor: set layout and defult settings
	 */
	public IceCreamLineManager(){
		super(new BorderLayout());
		line = new IceCreamLine();
		add(line,BorderLayout.CENTER);
		addControls();
	}
	
	/**
	 * Add addOrderButton and serveNextButton to the panel
	 */
	private void addControls(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(createNewOrderButton());
		panel.add(createRemoveNextButton());
		add(panel, BorderLayout.NORTH);
	}
	
	/**
	 * Create and define addOrder Button
	 * @return addOrder JButton
	 */
	private JButton createNewOrderButton(){
		JButton addOrder= new JButton("Add a random order");
		addOrder.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				line.addRandomOrder();
			}
		});
		
		return addOrder;
	}
	
	/**
	 * Create and define serveNext Button
	 * @return serveNext Button
	 */
	private JButton createRemoveNextButton(){
		JButton serveNext= new JButton("Serve the next order");
		serveNext.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				line.getNextOrder();
				repaint();
			}
		}); 
		
		return serveNext;
	}
	
	/**
	 * Method from ActionListner interface
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {}
}
