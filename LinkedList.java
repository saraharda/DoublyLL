/**
 * @author Sara Harda
 * 11/06/2016
 */

public class LinkedList<T>
{
	//instance of the head of the LinkedList
	protected LinkedListNode<T> head; 

	/**
	 * Constructor
	 */
	public LinkedList() {
		head=null;  
	}

	/**
	 * Get data stored in head node of list.
	 */
	public T getFirst() {
		if(head!=null) {
			return head.getData(); 
		}
		else {

			return null; 
		}
	}

	/**
	 * Get the head node of the list.
	 * @return head
	 */
	public LinkedListNode<T> getFirstNode() {
		if(head!=null) {
			return head;
		}
		else {
			return null;
		}
	}

	/**
	 * Get data stored in last node of list.
	 * @return last node data
	 */
	public T getLast() 
	{
		LinkedListNode<T> temp= new LinkedListNode<T>();
		temp=head;
		if(head==null) {
			return null;
		}
		while(temp.getNext()!=null) {
			temp=temp.getNext(); 
		}
		return temp.getData();
	}

	/**
	 * Get the tail node of the list.
	 */
	public LinkedListNode<T> getLastNode() {
		LinkedListNode<T> temp= new LinkedListNode<T>();
		temp=head; 
		if(head==null) {
			return null;
		}
		while(temp.getNext()!=null) {
			temp=temp.getNext(); 
		}
		return temp;		
	}

	/**
	 * Insert a new node with data at the head of the list.
	 * @param data stored
	 */
	public void insertFirst(T data) {
		LinkedListNode<T> newNode= new LinkedListNode<T>();
		newNode.setData(data); 
		newNode.setNext(head);  
		head=newNode;
	}

	/**
	 * Insert a new node with data after currentNode
	 */
	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		LinkedListNode<T> newNode= new LinkedListNode<T>(); 
		newNode.setData(data);
		LinkedListNode<T> node= new LinkedListNode<T>(); 
		node=head; 
		LinkedListNode<T> temp= new LinkedListNode<T>();
		while( node!=null) {
			if(node.equals(currentNode)) {
				temp=node.getNext();
				node.setNext(newNode); 
				newNode.setNext(temp); 
			}
			node=node.getNext(); 
		}
	}

	/**
	 * Insert a new node with data at the end of the list.
	 */
	public void insertLast(T data) {
		LinkedListNode<T> temp= new LinkedListNode<T>();
		temp=head; 
		if(head==null) 
		{
			insertFirst(data);
		}
		else
		{
			while(temp.getNext()!=null)
			{
				temp=temp.getNext(); 
			}
			insertAfter(temp,data);
		}
	}

	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		if(head==null) {
			System.out.println("head is null");
		}
		head=head.getNext();	
	}
	
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 */
	public void deleteNext(LinkedListNode<T> currentNode) {
		LinkedListNode<T> node= new LinkedListNode<T>();
		node=head;
		LinkedListNode<T> temp= new LinkedListNode<T>();
		temp=node;  
		while(node.getNext()!=null) {
			node=node.getNext();
			if(node.equals(currentNode)) {
				temp=node;
			}
			if(node.getNext()==null) {
			}
		}
		temp.setNext(temp.getNext().getNext());
	}

	/**
	 * Remove the last node
	 */
	public void deleteLast() {
		LinkedListNode<T> temp= new LinkedListNode<T>(); 
		temp=head; 
		while(temp.getNext().getNext()!=null) 
		{
			temp=temp.getNext();

		}
		temp.setNext(null); 
	}

	/**
	 * Return the number of nodes in this list.
	 */
	public int size() {
		if(head==null) {
			return 0;
		}
		int size=1; 
		LinkedListNode<T> temp= new LinkedListNode<T>(); 
		temp=head;
		while(temp.getNext()!=null) {
			temp=temp.getNext(); 
			size++; 
		}
		return size; 
	}

	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		if(head==null) {	
			return true; 
		}
		return false;	
	}

	/**
	 * Return a String representation of the list.
	 */
	public String toString() {
		String string=""; 
		LinkedListNode<T> temp= head; 

		while(temp!=null) {
			string+= temp.getData(); 
			temp=temp.getNext(); 
		}
		return string;
	}
}
