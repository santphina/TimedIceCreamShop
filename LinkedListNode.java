/**
 * Node in the datastructure LinkedList
 * @author Xiaofan Xu
 *
 * @param <T> any data type
 */
public class LinkedListNode<T> {
	private T  data;
	private LinkedListNode<T> next;
	
	/**
	 * Set the data stored at this node.
	 * @param data input data
	 */
	public void setData( T data ){
		this.data = data;
	}
	 
	/**
	 * Get the data stored at this node.
	 * @return Instance variable data
	 */
	public T getData(){
		return data;
	}
	 
	/**
	 * Set the next pointer to passed node.
	 * @param node node to be set as the next
	 */
	public void setNext( LinkedListNode<T> node ){
		next = node;
	}
	 
	/**
	 * Get the next node
	 * @return (pointer to) next node
	 */
	public LinkedListNode<T> getNext(){
		return next;
	}
	 
	/**
	 * Get the data of the node in the format of string
	 * @Return a String representation of this node.
	 */
	public String toString(){
		return data.toString();
	}
}
