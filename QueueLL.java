/**
 * DataStructure: Queue (First In, First Out)
 * Implements the interface Queue<T>
 * @author Xiaofan Xu
 * @param <T> any data type
 */
public class QueueLL<T> implements Queue<T> {
	private LinkedList<T> ll;
	
	/**
	 * Constructor: Initiate the variable ll
	 */
	public QueueLL(){
		ll = new LinkedList<T>();
	}
	
	/**
	 * Adds an element to the end of the queue.
	 * @param data to be added to the Queue.
	 **/
	@Override
	public void enqueue(T data) {
	
		ll.insertLast(data);
	}

	/**
	 * Removes the front element of the queue and returns it.
	 * @return the dequeued data
	 **/
	@Override
	public T dequeue() {
		T data =ll.getFirst(); 
		ll.deleteFirst();
		return data;
	}

	/** 
	 * Gets the element at the front of the queue without removing it.
	 * @return the peeked data
	 **/
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return ll.getFirst();
	}

	/** 
	 * Tests if the queue is empty.
	 * @return true if the queue is empty
	 **/
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return ll.isEmpty();
	}
	
	/** 
	 * Returns a String representation of the queue.
	 * @return queue as String
	 **/
	@Override
	public String toString() {
		return ll.toString();
		
	}
	 
}
