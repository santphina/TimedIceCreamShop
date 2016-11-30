/**
 * The Queue interface encapsulates the ADT for a queue data structure.
 * @author Xiaofan Xu
 *
 * @param <T> any data type
 */
public interface Queue<T> {
	public void enqueue(T data);
	public T dequeue(); 
	public T peek(); 
	public boolean isEmpty(); 
	public String toString();
}