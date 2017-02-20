import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LinkedListTest {
	
	//tests need some tweaking after deletion
	//create new linkedLists to test instead of arraylists
	
//	private LinkedList<String> list = new LinkedList<String>();
//	private LinkedList<String>  list2 = new LinkedList<String>();

	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	String stringForChangedElement = "ghi";
	
	public void addToList() {
		list.add("abc");
		list.add("def");
		list.add("lmnop");
		list.add("xyz");
	}
	
	public void addToList2() {
		list2.add("abc");
		list2.add("def");
		list2.add("lmnop");
		list2.add("xyz");
	}
	
	
	//testing isEmpty method - check that array list size is 0
	@Test
	public void testIsEmpty() {
		assertEquals(0, list.size());
	}

	
	
	//testing add(E) method - checking array list size not zero and equal to list.size();
	//check that list size increases from previous list size after adding new elements. could also check num of elements added
	//to list equals old list size plus new list size
	@Test
	public void testAddNotZero() {
		addToList();
		assertNotEquals(0, list.size());
	}
	
	@Test
	public void testAddEqualSize() {
		addToList();
		list.add(stringForChangedElement);
		assertEquals(5, list.size());
	}
	
	@Test
	public void testAddSizeChanges() {
		int listSize = list.size();
		addToList();
		assertNotEquals(listSize, list.size());
	}
	
	
	
	//testing get(E) method - checking get(0) and get(list.size()) returns correct values
	@Test
	public void testGetFirstItem() {
		addToList();
		assertEquals("abc", list.get(0));
	}
	
	@Test
	public void testGetLastItem() {
		addToList();
		assertEquals("xyz", list.get(list.size()-1));
	}
	
	
	
	//testing add(int E) method when item added at specified index
	//check if list size increases by one, check get(i) added, check get(i-1) not changed, check get(i+1) changed
	//this checks changes to elements by comparing a duplicate arrayList that doesn't get changed. This avoids the duplicates
	//problem
	@Test
	public void testAddIntChecki() {
		addToList();
		addToList2();
		
		int checkIndex = 2;
		list.add(checkIndex, stringForChangedElement);
		assertEquals(stringForChangedElement, list.get(checkIndex));
	}
	
	@Test
	public void testAddIntCheckiplus1() {
		addToList();
		addToList2();
		
		int checkIndex = 2;
		list.add(checkIndex, stringForChangedElement);
		
		assertEquals(list.get(checkIndex+1), list2.get(checkIndex));
	}
	
	@Test
	public void testAddIntCheckiminus1() {
		addToList();
		addToList2();
		
		int checkIndex = 2;
		list.add(checkIndex, stringForChangedElement);
		
		assertEquals(list.get(checkIndex-1), list2.get(checkIndex-1));
	}
	
	@Test
	public void testAddIntCheckSizeIncr() {
		addToList();
		int listSize = list.size();
		list.add(2, stringForChangedElement);
		assertEquals(listSize+1, list.size());
	}
	
	
	
	//testing set(int E) method when one element is replaced with another at the specified index
	//chceck list size remains the same, get(i) changes, get(i-1) doesn't change, get(i+1) same
	//manua method of checking - have to look up each time from the list at the required index
	@Test
	public void testSetIntChecki() {
		int checkIndex = 2;
		addToList();
		list.set(checkIndex, stringForChangedElement);
		assertEquals(stringForChangedElement, list.get(checkIndex));
	}
	
	@Test
	public void testSetIntCheckiminus1() {
		int checkIndex = 2;
		addToList();
		list.set(checkIndex, stringForChangedElement);
		assertEquals("def", list.get(checkIndex-1));
	}
	
	@Test
	public void testSetIntCheckiplus1() {
		int checkIndex = 2;
		addToList();
		list.set(checkIndex, stringForChangedElement);
		assertEquals("xyz", list.get(checkIndex+1));
	}
	
	@Test
	public void testSetIntCheckSizeSame() {
		addToList();
		int listSize = list.size();
		list.set(2, stringForChangedElement);
		assertEquals(listSize, list.size());
	}
	
	
	//testing remove(int) method - element at specified index gets removed from list
	//check list size decrease by 1, check get(i) changes, check get(i-1) doesn't change, check get(i+1) changes
	//these methods only check that the elements have changed or not changed as required - this may fail if there are duplicate
	//items in the list
	@Test
	public void testRemoveIntChecki() {
		addToList();
		int checkIndex = 1;
		String checkElement = list.get(checkIndex);
		list.remove(checkIndex);
		assertNotEquals(checkElement, list.get(checkIndex));
	}
	
	@Test
	public void testRemoveIntCheckiminus1() {
		addToList();
		int checkIndex = 1;
		String checkElement = list.get(checkIndex-1);
		list.remove(checkIndex);
		assertEquals(checkElement, list.get(checkIndex-1));
	}
	
	@Test
	public void testRemoveIntCheckiplus1() {
		addToList();
		int checkIndex = 1;
		String checkElement = list.get(checkIndex+1);
		list.remove(checkIndex);
		assertNotEquals(checkElement, list.get(checkIndex+1));
	}
	
	@Test
	public void testRemoveIntCheckSizeSame() {
		addToList();
		int listSize = list.size();
		list.remove(2);
		assertEquals(listSize-1, list.size());
	}
	
	//testing contains(Object) - returns true if list contains specified element, false if not
	//test to assert true if item contained in list, false if element not contained in list
	//can also test after .remove method or .add method, however this won't work if there are duplicates
	@Test
	public void testContainsObject() {
		addToList();
		String check = "abc";
		
		assertTrue(list.contains(check));
	}
	
	@Test
	public void testDoesntContainObject() {
		addToList();
		String check = stringForChangedElement;
		
		assertFalse(list.contains(check));
	}

}
