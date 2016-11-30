import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * This class maintain a queue of ice cream cone orders using the Queue class and the IceCreamCone class.
 * Each order has an ice cream cone with between 1 and 4 random scoop flavors.
 * When displaying your ice cream line, box class is used. 
 * There are methods to create a new order and add it to the line as well as to remove the next order from the line.
 * @author Xiaofan Xu
 */
public class IceCreamLine extends Box{
	private Queue<IceCreamCone> orderLine;
	private Queue<IceCreamConeView> orderLineView;
	
	/**
	 * Constructor: Set Boxlayout & initiate parameters
	 */
	public IceCreamLine(){
		super(BoxLayout.Y_AXIS);
		orderLine = new QueueLL<IceCreamCone>();
		orderLineView = new QueueLL<IceCreamConeView>();
	}
	
	/**
	 * Check if the queue is empty
	 * @return false if the queue is empty
	 */
	public boolean hasOrder(){
		if (orderLine.isEmpty() == true){
			return false;
		}
		return true;
	}
	 
	
	/**
	 * Add a new order of ice-cream
	 * @param cone the IceCreamCone to be added
	 */
	public void addOrder(IceCreamCone cone){
		IceCreamConeView coneView = new IceCreamConeView(cone);
		orderLine.enqueue(cone);
		orderLineView.enqueue(coneView);
		add(coneView);
		validate();
		repaint();
	}
	
	/**
	 * Create an IceCreamCone of random order
	 * @return an IceCreamCone of random order
	 */
	public IceCreamCone addRandomOrder(){
		IceCreamCone cone = IceCreamCone.createRandom();
		addOrder(cone);
		return cone;
	}
	
	/**
	 * Dequeue the IceCreamCone that is already finished
	 * @return the IceCreamCone that get dequeued
	 */
	public IceCreamCone getNextOrder(){
		
		IceCreamConeView cv = orderLineView.peek();
		IceCreamCone c = orderLine.peek();
		if (cv != null && c!=null) {
			orderLineView.dequeue();
			remove(cv);
		}

		validate();
		repaint();
		
		return orderLine.dequeue();
		
	}
}
