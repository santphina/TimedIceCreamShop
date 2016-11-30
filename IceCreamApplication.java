import javax.swing.*;

/**
 * Application (Create a JFrame) for the IceCreamMaker class
 * @author Xiaofan Xu
 *
 */
public class IceCreamApplication {
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
		JFrame f = new JFrame("Ice cream cone maker");
		f.add(new IceCreamMaker());
		f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
