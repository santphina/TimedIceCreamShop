import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * View: Draw cone and scoops on the screen
 * @author Xiaofan Xu
 *
 */
public class IceCreamConeView extends JComponent{
	
	public static final Color[] PAINT_COLORS={Color.white, Color.pink, Color.green, new Color(156, 93, 82), Color.yellow};
	public static final int CONE_WIDTH = 40;
	public static final int CONE_HEIGHT = 60;
	public static final int SCOOP_DIAMETER = 50;
	public static final int SCOOP_OVERLAP = 10;
	private IceCreamCone cone;
	
	/**
	 * Pass the IceCreamCone Stack in 
	 * @param cone Stack that saves all the scoops that exist
	 */
	public IceCreamConeView(IceCreamCone cone){
		this.cone = cone;
	}
	
	/**
	 * Draw the cone and the scoops
	 * @param g graphics object to draw on
	 */
	public void paint(Graphics g){
		paintCone(g);
		paintScoops(g);
	}
	
	/**
	 * Paint the cone of a ice-cream
	 * @param g graphics object to draw on
	 */
	public void paintCone(Graphics g) {
		int x1 = getWidth()/2 - CONE_WIDTH/2;
		int x2 = getWidth()/2;
		int x3 = getWidth()/2 + CONE_WIDTH/2;
		int y1 = getHeight()-CONE_HEIGHT;
		int y2 = getHeight();
		int y3 = getHeight()-CONE_HEIGHT;
		int[] x = {x1, x2, x3};
		int[] y = {y1, y2, y3};
		g.setColor(PAINT_COLORS[4]);
		g.fillPolygon(x,y,3);
	}
	
	/**
	 * Draw the scoop of a ice-cream
	 * @param g graphics object to draw on
	 * @param flavorId ID for the flavor of the scoop
	 * @param x x-coordinate value that the scoop should be drawn at
	 * @param y y-coordinate value that the scoop should be drawn at
	 */
	public void paintScoop(Graphics g, int flavorId, int x, int y){
		g.setColor(PAINT_COLORS[flavorId]);
		g.fillOval(x,y,SCOOP_DIAMETER,SCOOP_DIAMETER);
	}
	
	/**
	 * Draw all the scoops that are in the cone stack
	 * @param g graphics object to draw on
	 */
	private void paintScoops(Graphics g){
		int x = getWidth()/2 - SCOOP_DIAMETER/2;
		int y = getHeight()-CONE_HEIGHT-SCOOP_DIAMETER+SCOOP_OVERLAP;
		
		Stack<Integer> tStack = cone.getScoopFlavorStack();
		Stack<Integer> rStack = new StackLL<Integer>();
		if(!tStack.isEmpty()){
			while(!tStack.isEmpty()) {
				rStack.push(tStack.pop());
		      }
			while(!rStack.isEmpty()) {
				tStack.push(rStack.peek());
				paintScoop(g, rStack.pop(), x, y);
	    	    y = y - SCOOP_DIAMETER + SCOOP_OVERLAP;
			}
		}
	}
}

