import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the DoublyLinkedListNode class 
 * @author Sara Harda
 * 02/08/2017
 */

public class DLLNodeTest {

	@Test
	public void testConstructor(){
		DoublyLinkedListNode<String> list = new DoublyLinkedListNode<String>();
		assertEquals("previous of the node is null", null, list.getPrev());
		assertEquals("next of the node is null", null, list.getNext());
		assertEquals("the data of the node is null", null, list.getData());

		list.setData("x");
		assertEquals("set data for the node", "x", list.getData());	
	}
	
	@Test
	public void testGetNext() {
		DoublyLinkedListNode<String> doublyLinkedListNode = new DoublyLinkedListNode<String>();
		assertEquals("next node is null", null, doublyLinkedListNode.getNext());

		DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
		doublyLinkedList.insertFirst("x");
		assertEquals("previous node of head is null", null, ((DoublyLinkedListNode<String>)doublyLinkedList.getFirstNode()).getNext());

		doublyLinkedList.insertFirst("y");
		assertEquals("next node of y is x", "x", doublyLinkedList.getFirstNode().getNext().getData());
	}

	@Test
	public void testSetNext(){
		DoublyLinkedListNode<String> node1 = new DoublyLinkedListNode<String>();
		node1.setData("y");

		DoublyLinkedListNode<String> node2 = new DoublyLinkedListNode<String>();
		node2.setData("x");
		node2.setNext(node1);
		assertEquals("next node of x is y", "y", node2.getNext().getData());
	}

	@Test
	public void testGetPrevious() {
		DoublyLinkedListNode<String> doublyLinkedListNode = new DoublyLinkedListNode<String>();
		assertEquals("previous node is null", null, doublyLinkedListNode.getPrev());
		
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("x");
		assertEquals("previous of head is null", null, ((DoublyLinkedListNode<String>)list.getFirstNode()).getPrev());

		list.insertFirst("y");
		assertEquals("previous node of x is y", "y", list.getLastNode().getPrev().getData());
	}

	@Test
	public void testSetPrevious(){
		DoublyLinkedListNode<String> node1 = new DoublyLinkedListNode<String>();
		node1.setData("y");

		DoublyLinkedListNode<String> node2 = new DoublyLinkedListNode<String>();
		node2.setData("x");

		node2.setPrev(node1);
		assertEquals("previous node of x is y", "y", node2.getPrev().getData());
	}
}
