/**
 * @author Xiaofan Xu 
 * Model: Update and maintain the stack
 */
public class IceCreamCone {
	/**
	 * All flavors of the Ice-cream offered
	 */
	public static final String[] FLAVORS = {"vanilla", "strawberry", "green tea", "burnt caramel"};
	/**
	 * Stack, that saves the current number and types of the scoops on the cone
	 */
	private StackLL<Integer> ScoopFlavorStack;

	/**
	 * Constructor: Initiate ScoopFlavorStack 
	 */
	public IceCreamCone(){
		ScoopFlavorStack = new StackLL<Integer>();
	}

	/**
	 * return the ScoopFlavorStack stack
	 * @return ScoopFlavorStack
	 */
	public StackLL<Integer> getScoopFlavorStack(){
		return ScoopFlavorStack;
	}
	
	/**
	 * Find the index of a particular flavor
	 * @param flavor of the scoop
	 * @return Index for the flavor of the scoop 
	 */
	private int findFlavorIdx (String flavor){
		switch(flavor){
			case "vanilla":
				return 0;
			case "strawberry":
				return 1;
			case "green tea":
				return 2;
			case "burnt caramel":
				return 3;
			default:
				return -1;
		}
	}
	
	/**
	 * Add new scoop to the current stack
	 * @param flavor flavor of the scoop
	 */
	public void addScoop (String flavor){
		ScoopFlavorStack.push(findFlavorIdx(flavor));
	}
	
	/**
	 * Delete and return the scoop value at the top of the stack
	 * @return flavor of the scoop in string
	 */
	public String PopTopScoop(){
		int flavor = -1;
		flavor = ScoopFlavorStack.pop();
		
		if ( flavor > -1 && flavor < 4) {
			return FLAVORS[flavor];
		}
		else {return Integer.toString(flavor);}
	}
	
	/**
	 * Generate a random IceCreamCone
	 * @return a random IceCreamCone
	 */
	public static IceCreamCone createRandom(){
		
		IceCreamCone iceCreamCone = new IceCreamCone();
		
		double randomNum = Math.random();
		int numScoops = (int) (randomNum*3) + 1;
		
		for (int i =0; i < numScoops; i++){
			iceCreamCone.getScoopFlavorStack().push((int) (Math.random()*4));
		}
		return iceCreamCone;
	}

}
