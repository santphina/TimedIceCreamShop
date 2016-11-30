/**
 * DataStructure: Stack (First In, Last Out)
 * Implements the interface Stack<T>
 * @author Xiaofan Xu
 * @param <T> any data type
 */

public class StackLL<T> implements Stack<T> {
	
	private LinkedList<T> ll;
	
	/** 
	 * Constructor: Initiate the variable ll
	 */
	public StackLL(){
		ll = new LinkedList<T>();
	}
	
	/**
	 * Pushes an element onto the top of the stack.
	 * @param data data to be added to the stack
	 */
	public void push( T data ){
		ll.insertFirst(data);
	}

	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 */
	 public T pop(){
		 T r = ll.getFirst();
		 if (r!=null){
			 ll.deleteFirst();
			 return r;
		 }
		 else {return null;}
	 }

	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 */
	 public T peek() {
		 return ll.getFirst();
	 }

	/** 
	 * Tests if the stack is empty.
	 * @return true if the stack is empty
	 */
	 public boolean isEmpty(){
		 return ll.isEmpty();
	 }

	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 */
	 public String toString(){
		 return ll.toString();
	 }
	 
	 /** 
	  * Get number of elements in the stack
	   * @return size of the stack
	   */
	 public int size() {
		 return ll.size();
	 }
	
}
