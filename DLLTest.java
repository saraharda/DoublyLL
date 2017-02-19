import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Thorough test of the doubly linked list class
 * @author Sara Harda
 * 31/01/2017
 */

public class DLLTest {

	@Test
	public void testConstructor() {
		DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
		assertEquals("head is equal to null", null, doublyLinkedList.getFirstNode());
		assertEquals("tail is equal to null", null, doublyLinkedList.getLastNode());

		doublyLinkedList.insertFirst("z");
		assertEquals("head has data z", "z", doublyLinkedList.getFirstNode().toString());
		assertEquals("tail has data z", "z", doublyLinkedList.getLastNode().toString());
	}
	
	@Test
	public void testString() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("w");
		assertEquals("w", "w"+"\n", list.toString() );
		
		list.insertFirst("x");
		list.insertFirst("y");
		list.insertFirst("z");

		assertEquals("the list should be zywx", "z"+"\n"+"y"+"\n"+"x"+"\n"+"w"+"\n", list.toString() );
	}

	@Test
	public void testEmpty() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertEquals("list is empty", true, list.isEmpty());

		list.insertFirst(null);			
		assertEquals("the list is empty", true, list.isEmpty());
		
		list.insertFirst("x");	
		assertEquals("list is not empty", false, list.isEmpty());

		list.insertFirst("");			
		assertEquals("list is not empty", false, list.isEmpty());

	}

	@Test
	public void testSize() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertEquals("size equal to 0", 0, list.size());

		list.insertFirst("x");
		assertEquals("size equal to 1", 1, list.size());

		list.insertFirst("w");
		list.insertFirst("y");
		list.insertFirst("z");
		assertEquals("size equal to 4", 4, list.size());
	}

	@Test
	public void testInsertFirst() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("x");
		assertEquals("first node of list is x", "x", list.getFirst());
		assertEquals("next to first node is null", null, list.getFirstNode().getNext());
		assertEquals("previous to first node is null", null, ((DoublyLinkedListNode<String>) list.getFirstNode()).getPrev());

		list.insertFirst("y");
		assertEquals("first node of list is y", "y", list.getFirst());
		assertEquals("next to first node is x", "x", list.getFirstNode().getNext().toString());
		assertEquals("previous to first node is y", "y", ((DoublyLinkedListNode<String>) list.getFirstNode().getNext()).getPrev().toString());
	}

	@Test
	public void testInsertLast() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();

		list.insertLast("x");
		assertEquals("first node of the list is x", "x", list.getFirst());

		list.insertLast("y");
		assertEquals("first node of the list is x", "x", list.getFirst());
		assertEquals("node next to first is y", "y", list.getLastNode().toString());
		assertEquals("node previous to last is x", "x", list.getLastNode().getPrev().toString());
	}
	
	@Test
	public void testGetLastNode(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertEquals("last node is null", null, list.getLastNode());

		list.insertFirst("x");
		assertEquals("get last node", "x", list.getLastNode().toString());

		list.insertLast("y");
		assertEquals("get last node", "y", list.getLastNode().toString());
	}

	@Test
	public void testInsertAfter() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertFirst("x");
		list.insertAfter((DoublyLinkedListNode<String>)list.getFirstNode(), "y");

		assertEquals("first node of the list is x", "x", list.getFirst());
		assertEquals("next to first node is y", "y", list.getFirstNode().getNext().toString());

		list.insertAfter((DoublyLinkedListNode<String>)list.getFirstNode(), "z");
		assertEquals("next to first node is z", "z", list.getFirstNode().getNext().toString());
		assertEquals("last node of the list is y", "y", list.getLastNode().toString());
		assertEquals("previous node to z is x", "x", ((DoublyLinkedListNode<String>) list.getFirstNode().getNext()).getPrev().toString());
	}

	@Test
	public void testDeleteFirst() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.deleteFirst();
		list.insertFirst("x");
		list.deleteFirst();
		assertEquals("head of the list is null", null, list.getFirstNode());
		assertEquals("tail of the list is null", null, list.getLastNode());

		list.insertFirst("x");
		list.insertLast("y");
		list.insertAfter((DoublyLinkedListNode<String>)list.getFirstNode(), "z");
		list.deleteFirst();
		assertEquals("head of the list is z", "z", list.getFirst());
		assertEquals("tail of the list is y", "y", list.getLastNode().toString());
		
		list.insertFirst("a");
		list.insertFirst("b");
		list.insertFirst("c");
		list.insertFirst("d");
		list.deleteFirst();
		list.deleteFirst();
		list.deleteFirst();
		assertEquals("head of the list is a", "a", list.getFirst());
	}

	@Test
	public void testDeleteLast(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.deleteLast();
		assertEquals("the last node is null", null, list.getLastNode());
		assertEquals("the first node is null", null, list.getFirstNode());

		list.insertFirst("x");
		list.deleteLast();
		assertEquals("the last node is null", null, list.getLastNode());
		assertEquals("the first node is null", null, list.getFirstNode());
		
		list.insertLast("x");
		list.deleteLast();
		assertEquals("the last node is null", null, list.getLastNode());
		assertEquals("the first node is null", null, list.getFirstNode());
		
		list.insertFirst("x");
		list.insertFirst("y");
		list.insertFirst("z");
		list.insertAfter((DoublyLinkedListNode<String>)list.getFirstNode(), "r");
		list.insertFirst("d");
		list.insertFirst("b");
		list.deleteLast();
		assertEquals("the last node is y", "y", list.getLastNode().toString());
		assertEquals("the first node is b", "b", list.getFirstNode().toString());
	}

	@Test
	public void testDeleteNext(){
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.deleteNext((DoublyLinkedListNode<String>)list.getFirstNode());
		list.insertFirst("x");
		list.deleteNext((DoublyLinkedListNode<String>)list.getFirstNode());
		assertEquals("the last node is x", "x", list.getLastNode().toString());
		assertEquals("the last of the node is x", "x", list.getFirstNode().toString());

		list.insertLast("y");
		list.deleteNext((DoublyLinkedListNode<String>)list.getFirstNode());
		assertEquals("the last node is x", "x", list.getLastNode().toString());

		list.insertFirst("y");
		list.insertFirst("z");
		list.deleteNext((DoublyLinkedListNode<String>)list.getFirstNode());		
		assertEquals("the last node is x", "x", list.getLastNode().toString());
		assertEquals("the first node is z", "z", list.getFirstNode().toString());
		assertEquals("the next node of z is x", "x", list.getFirstNode().getNext().toString());
		assertEquals("the previous node of x", "z",list.getLastNode().getPrev().toString());
	}
}


