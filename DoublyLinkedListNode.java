/**
 * DoublyLinkedListNode extends LinkedListNode 
 * Includes the previous node and inherits the next node
 * @author Sara Harda
 * 02/08/2017
 */

public class DoublyLinkedListNode<T> extends LinkedListNode<T>{

	//instance of previous node
	private DoublyLinkedListNode<T> previous;

	/**
	 * Constructor
	 */
	DoublyLinkedListNode(){
		super();
		previous = null;
	}

	/**
	 * Gets the preceding node
	 */
	public DoublyLinkedListNode<T> getPrev(){
		return this.previous;	
	}

	/**
	 * Sets the preceding node
	 */
	public void setPrev( DoublyLinkedListNode<T> node){
		this.previous = node;
	}
}
