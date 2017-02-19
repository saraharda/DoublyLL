/**
 * @author Sara Harda
 * 11/06/2016
 */

public class LinkedListNode<T> 
{
	private T data;
	protected LinkedListNode<T> next;

	/**
	 * Constructor
	 */
	public LinkedListNode(){

	}

	/**
	 * Set the data stored at this node.
	 */
	public void setData(T data) {
		this.data=data;
	}

	/**
	 * Get the data stored at this node.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the next pointer to passed node.
	 */
	public void setNext(LinkedListNode<T> node)  {
		next=node;
	}

	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * Returns a String representation of this node.
	 */
	public String toString() {
		return data.toString();
	}
}
