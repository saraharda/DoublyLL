import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the LinkedList class 
 * @author Sara Harda
 * 01/31/2017
 */

public class LLTester {
	
	//instance of a linked list
	LinkedList<String> list = new LinkedList<String>();

	/**
	 * Tests the getFirst() and insertFirt() methods
	 */
	@Test
	public void firstTest() {
		list.insertFirst("X");
		assertEquals("First node should be 'X'","X", list.getFirst());
	}

	/**
	 * Tests the insertAfter() and getFirstNode() methods
	 */
	@Test
	public void afterTest() {
		list.insertFirst("X");
		list.insertAfter(list.getFirstNode(), "Y");
		assertEquals("Node after the first one should be 'Y'","Y",list.getFirstNode().getNext().getData());
	}

	/**
	 * Tests insertLast() and getLast() methods
	 */
	@Test
	public void lastTest() {
		list.insertFirst("X");
		list.insertAfter(list.getFirstNode(), "Y");
		list.insertLast("Z");
		assertEquals("Last node of the list should be 'Z'","Z",list.getLast());
		assertEquals("The size of the LinkedList should now be 3", 3,list.size());
	}

	/**
	 * Tests the deleteFirst() method
	 */
	@Test
	public void deleteFirstTest() {
		list.insertFirst("X");
		list.insertAfter(list.getFirstNode(), "Y");
		list.insertLast("Z");
		list.deleteFirst();
		assertEquals("Testing if first node was deleted, so new first node should have data 'Y'","Y",list.getFirst());
	}

	/**
	 * Tests the deleteNext() method
	 */
	@Test
	public void deleteNextTest() {
		list.insertFirst("X");
		list.insertAfter(list.getFirstNode(), "Y");
		list.insertLast("Z");
		list.deleteNext(list.getFirstNode());
		assertEquals("Second node should be 'Z'","Z", list.getFirstNode().getNext().getData());
	}

	/**
	 * Tests the deleteLast() method
	 */
	@Test
	public void deleteLastTest() {
		list.insertFirst("X");
		list.insertAfter(list.getFirstNode(), "Y");
		list.insertLast("Z");
		list.deleteLast();
		assertEquals("Testing if first node was deleted, so last data should now be 'Y'","Y",list.getLast());
	}
	
	/**
	 * Tests the size method
	 */
	@Test
	public void sizeTest() {
		assertEquals("Size of list should be equal to 0", 0, list.size());
	}
	
	/**
	 * Test the isEmpty method
	 */
	@Test
	public void isEmptyTest() {
		assertEquals("LinkedList should be empty", true, list.isEmpty());
	}

	/**
	 * Tests the toString method (example from CS201)
	 */
	@Test
	public void toStringTest() {
		list.insertFirst("a");
		list.insertFirst("v");
		list.insertFirst("a");
		list.insertFirst("l");
		list.insertFirst("o");
		list.insertFirst("i");
		list.insertAfter(list.getFirstNode().getNext(), "j");
		list.insertAfter(list.getFirstNode().getNext(), "e");
		list.insertAfter(list.getFirstNode().getNext(), "v");
		list.insertAfter(list.getFirstNode(), "l");
		list.deleteNext(list.getFirstNode().getNext().getNext()
				.getNext().getNext());
		System.out.println(list.toString());
	}
}
