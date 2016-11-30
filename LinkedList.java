/**
 * DataStructure: LinkedList
 * @author Xiaofan Xu
 *
 * @param <T> any data type
 */
public class LinkedList<T> {
	private LinkedListNode<T> head;
	
	public LinkedList(){
		head = new LinkedListNode<T>();
	}
	/**
	 * Get the data of the fist node in the LinkedList
	 * @return Data stored in head node of list
	 */
	public T getFirst() {
		if (head == null) {
			return null;
		}
		if (head.getData()==null) {
			return null;
		}
		return head.getData();
	}
	 
	/** 
	 * Get the first node of the LinkedList
	 * @return Head node of the list
	 */
	public LinkedListNode<T> getFirstNode() {
		return head;
	}
	 
	/**
	 * Get the data of the last node in the LinkedList
	 * @return Data stored in last node of list.
	 */
	public T getLast() {
		  LinkedListNode<T> tmp;
	      tmp = getLastNode();
	      return tmp.getData();
	}
	 
	/**
	 * Get the last node of the LinkedList
	 * @return The tail node of the list.
	 */
	public LinkedListNode<T> getLastNode() {
		LinkedListNode<T> tmp = head;
		if (tmp == null) {
			return null;
		}
		if(tmp.getData() != null){
		      while(tmp.getNext() != null) {
		    	  tmp.setNext(tmp);
		      }
		}
		return tmp;
	}
	 
	/**
	 * Insert a new node with data at the head of the list.
	 * @param data the data to be inserted
	 */
	public void insertFirst( T data ) {
		LinkedListNode<T> tmpNew = new LinkedListNode<T>();
		tmpNew.setData(data);
		tmpNew.setNext(head);
		head = tmpNew;
	}
	 
	/**
	 * Insert a new node with data after currentNode
	 * @param the new node to be inserted
	 * @param data data in the new node
	 */
	public void insertAfter( LinkedListNode<T> currentNode, T data ) {
		LinkedListNode<T> nodeNew = new LinkedListNode<>(); 
		if (head == null) {
			head = nodeNew;
			nodeNew.setData(data);
		}
		else if(currentNode.getData() == null)
	         head.setData(data);
	    else
	      {
	    	 LinkedListNode<T> tmp = head;
	    	 while(tmp.getNext() != currentNode) {
		    	  tmp.setNext(tmp);
		      }

	         nodeNew.setData(data);
	         currentNode.setNext(nodeNew);
	      }
	}
	 
	/**
	 * Insert a new node with data at the end of the list.
	 * @param data data in the new node
	 */
	public void insertLast( T data ) {
		LinkedListNode<T> nodeNew = new LinkedListNode<T>(); 
		if (head == null) {
			head = nodeNew;
			nodeNew.setData(data);
		}
		else if(head.getData() == null)
	         head.setData(data);
	    else
	      {
	    	 LinkedListNode<T> tmp = head;
	    	 while(tmp.getNext() != null) {
	    		 tmp = tmp.getNext();
		      }
	         nodeNew.setData(data);
	         tmp.setNext(nodeNew);
	      }
	}
	 
	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		if(head != null){
			head = head.getNext();
		}
	}
	 
	/**
	 * Remove the last node
	 */
	public void deleteLast() {
		LinkedListNode<T> tmp = head;
   	 	while(tmp.getNext() != null) {
	    	  tmp.setNext(tmp);
	    }
        tmp.setNext(null);
	}
	 
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 * @param currentNode one node before the node to be removed
	 */
	public void deleteNext( LinkedListNode<T> currentNode ) {
		currentNode.setNext(currentNode.getNext().getNext());
	}
	 
	/**
	 * Give back the the number of nodes in the LinkedList
	 * @return the number of nodes in this list
	 */
	public int size() {
		int i = 0;
		LinkedListNode<T> tmp = head; 
		while(tmp != null) {
			i = i + 1;  
	    	tmp = tmp.getNext();  
	      }
		System.out.println("listsize" + i);
		return i;
	}
	 
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		if(head.getData() == null){
			return true;
		}
		return false;
	}
	 
	/**
	 * Write out all the data from each node in the LinkedList in a String
	 * @return a String representation of the list.
	 */
	public String toString() {
		String str = "";
		LinkedListNode<T> tmp = head;
		while(tmp!= null) {
	    	  str = str + tmp.getData() + "->";
	    	  tmp = tmp.getNext();
	    }
		return str;
	}
}
