import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Controller: Draw/Delete scoop on a screen according to the button clicked
 * @author Xiaofan Xu
 *
 */
public class IceCreamMaker extends JPanel implements ActionListener{
	private IceCreamCone cone;
	private IceCreamConeView coneView;
	private JButton[] btns;

	/**
	 * Set the layout to be border-style
	 * Initiate the JButton btns with values
	 * Initiate cone and the panel view
	 */
	public IceCreamMaker(){
		// Set the layout to be border-style
		super(new BorderLayout());
		// Create panel defaults
		JButton vanilla = new JButton("vanilla");
		JButton strawberry= new JButton("strawberry");
		JButton greentea= new JButton("green tea");
		JButton burntcaramel= new JButton("burnt caramel");
		JButton trash= new JButton("Trash the top scoop!");
		btns = new JButton[]{vanilla, strawberry, greentea, burntcaramel, trash};
		
		cone = new IceCreamCone();
		
		addMenu();
		refreshDisplay();
	}
	
	/**
	 * call paint() from IceCreamConeView
	 */
	public void refreshDisplay(){
		repaint();
	}
	
	/**
	 * @return the IceCreamCone 
	 */
	public IceCreamCone coneGetter(){
		return cone;
	}
	
	/**
	 * Set up the two menu bars on the top of the window
	 */
	public void addMenu(){
		// Display two button bars on the top of the panel
	    JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
	    panel.add(createFlavorMenu());
	    panel.add(creatTrashButton());
	    add(panel, BorderLayout.NORTH);
	    
	    coneView = new IceCreamConeView(cone);
		// Display coneView in the center of the panel
		this.add(coneView, BorderLayout.CENTER);
	}
	
	//Define addActionListener
	int i;
	private JPanel createFlavorMenu(){
		JPanel flavorPanel = new JPanel();
		for(i = 0; i<btns.length;i++){
			flavorPanel.add(btns[i]);
			btns[i].addActionListener(this);
		}
		return flavorPanel;
	}
	
	/**
	 * Activate the trash button and define the ActionListener for it
	 * @return JButton Trash
	 */
	private JButton creatTrashButton(){
		btns[4].addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cone.getScoopFlavorStack().peek()!=null){
					cone.PopTopScoop();
				}
				refreshDisplay();
			}
		});
		return btns[4];
	}

	@Override
	/**
	 * Different reactions when different button is pressed
	 * @param e Button pressed
	 */
	public void actionPerformed(ActionEvent e) {
		//code that reacts to the action...
		if (e.getSource()==btns[0]){
			cone.addScoop(btns[0].getText());
			refreshDisplay();
			return;
		}
		else if (e.getSource()==btns[1]){
			cone.addScoop(btns[1].getText());
			refreshDisplay();
			return;
		}
		else if (e.getSource()==btns[2]) {
			cone.addScoop(btns[2].getText());
			refreshDisplay();
			return;
		}
		else if (e.getSource()==btns[3]){
			cone.addScoop(btns[3].getText());
			refreshDisplay();
			return;
		}
		else {System.out.println("Top scoop deleted / There is no scoop, please add a scoop first");}
    }
}


