/**
 * DoublyLinkedList extends LinkedList,
 * It inherits the head and allows access to the tail of the list
 * @author Sara Harda
 * 02/08/2017
 */

public class DoublyLinkedList<T> extends LinkedList<T> {

	//Instantiate the tail of the list
	private DoublyLinkedListNode<T> tail = new DoublyLinkedListNode<T>();

	/**
	 * Constructor
	 */
	DoublyLinkedList() {
		super();
	}

	/**
	 * Inserts the data passed in at the first node of the list
	 */
	public void insertFirst(T data) {
		if (data!=null){
			DoublyLinkedListNode<T> node = new DoublyLinkedListNode<T>();
			node.setData(data);
			if (head == null) {
				//let the node be the head node
				head = node;
			}
			//if the first node is not null
			else {
				//set head as the next node for the new node
				node.setNext(head);
				//set the new node as the previous node of the head
				((DoublyLinkedListNode<T>)head).setPrev(node);
				//set the new node as the head node of the list
				head = node;
			}
		}
	}
	
	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter(DoublyLinkedListNode<T> currentNode, T data) {
		//instantiate a new node
		DoublyLinkedListNode<T> node= new DoublyLinkedListNode<T>();
		//set its data to the data passed in the method
		node.setData(data); 
		//instantiate a temp node as the head node
		DoublyLinkedListNode<T> temp=(DoublyLinkedListNode<T>) head;
		
		while(temp.getNext()!=null && !temp.equals(currentNode)){
			//set the temp node to be its next node
			temp=(DoublyLinkedListNode<T>) temp.getNext();
		}
		
		if(temp.equals(currentNode)){
			//if the temp node has a next node
			if(temp.getNext()!=null){
				node.setNext(temp.getNext());
				((DoublyLinkedListNode<T>) temp.getNext()).setPrev(node);
				currentNode.setNext(node);
				node.setPrev(currentNode);
			}
			//if the temp node doesn't have a next node
			else{
				insertLast(data);
				tail=getLastNode();
			}
		}
	}
	
	/**
	 * Inserts a node at the tail of the list 
	 */
	public void insertLast(T data) {
		DoublyLinkedListNode<T> node = new DoublyLinkedListNode<T>();
		node.setData(data);
		
		// if the list is empty
		if (isEmpty()) {
			head = node;
			tail = node;
		}

		//if the list is not empty
		else{
			tail = getLastNode();
			tail.setNext(node);
			//set next and previous nodes for the last node
			node.setNext(null);
			node.setPrev(tail);
			//set the tail to be the new last node
			tail = node;
		}
	}
	
	/**
	 * Deletes the first node of the list 
	 */
	public void deleteFirst() {
		if (!isEmpty()){
			//the new node points now to the second node of the list
			DoublyLinkedListNode<T> node = (DoublyLinkedListNode<T>) head.getNext();
			if (head.getNext()!=null){
				node.setPrev(null);
			}
			//the second node of the list is now the head
			head = node;
		}
	}

	/**
	 * Deletes the last node of the list 
	 */
	public void deleteLast() {
		tail = getLastNode();
		if(size()==1) {
			head=null;
			tail=null; 
			return;
		}
		if(size()>1) {
			DoublyLinkedListNode<T> penultimate=tail.getPrev();
			penultimate.setNext(null);
			tail=penultimate;
			return;
		}
		if(isEmpty()) {
			return;
		}
	}
	
	/**
	 * Deletes the node after the current node 
	 */
	public void deleteNext(DoublyLinkedListNode<T> currentNode) {
		tail = getLastNode();
		//if current node and next one isn't null 
		if( currentNode!=null&&currentNode.getNext()!=null){
			//if there is only one more node after the currentNode
			if(currentNode.getNext().getNext()!=null){
				currentNode.setNext(currentNode.getNext().getNext());
				((DoublyLinkedListNode<T>) currentNode.getNext()).setPrev(currentNode);
				return;
			}
			//when currentNode is penultimate node
			if(currentNode.getNext().getNext()==null) {
				tail=currentNode;
				tail.setNext(null);
				return;
			}
		}
		if(currentNode == tail) {
			return;
		}
	}

	/**
	 * Gets the last node of the list 
	 */
	public DoublyLinkedListNode<T> getLastNode(){
		if(isEmpty())
			return null;
		else{
			tail = (DoublyLinkedListNode<T>) head;
			while( tail.getNext()!=null){
				tail =  (DoublyLinkedListNode<T>) tail.getNext();
			}		
		}
		return tail;
	}

	/**
	 * Return a String representation of the list.
	 **/
	public String toString() {

		String s = "";
		if (isEmpty() != true) {
			DoublyLinkedListNode<T> curNode = (DoublyLinkedListNode<T>) head;
			while (curNode != null) {
				s += curNode.getData();
				curNode = (DoublyLinkedListNode<T>) curNode.getNext();
				s+="\n";
			}
		}
		return s;
	}
}


	
	


