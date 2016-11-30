import javax.swing.JFrame;

/**
 * Application (Create a JFrame) for the IceCreamLineManager class
 * @author Xiaofan Xu
 *
 */
public class IceCreamManagerApplication {
	/**
	 * Sets the width of the frame to 800 pixels
	 */
    public static int FRAME_WIDTH = 800;
	
	/**
	 * Sets the height of the frame to 600 pixels
	 */
    public static int FRAME_HEIGHT = 600;

	/**
	 * Creates and draws the frame for IceCreamMaker
	 * @param args not used
	*/
	public static void main(String[] args) {
		JFrame f = new JFrame("Ice cream line");
		f.add(new IceCreamLineManager());
		f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
