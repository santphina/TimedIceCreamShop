/** 
 * The Stack interface encapsulates the ADT for a stack data structure.
 * @author Xiaofan Xu
 *
 * @param <T> any data type
 */
public interface Stack<T> {
	public boolean isEmpty();
	public T peek();
	public T pop();
	public void push (T data);
	public String toString();
	public int size();
}