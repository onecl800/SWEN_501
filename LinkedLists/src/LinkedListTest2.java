import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

//public class LinkedListTest2 {
//
//ArrayList<String> list, listA, listB, listC, listD, listE;
//	
//	int listsize = 6;
//	
//	@Before
//	public void listSetup(){
//		list = new ArrayList<String>();
//		listA = new ArrayList<String>(Arrays.asList("a","b","c","d","e","f"));
//		listB = new ArrayList<String>(Arrays.asList("a","a","b","b","c","c"));
//		listC = new ArrayList<String>(Arrays.asList("a","b","c","d","e","f"));
//		listD = new ArrayList<String>(Arrays.asList("b", "c", "d", "e", "f"));
//		listE = new ArrayList<String>(Arrays.asList("a","b","c","d","e"));
//	}
//	
//	//test that the isEmpty method returns true on an empty list
//	@Test
//	public void testIsEmpty(){
//		assertTrue(list.isEmpty());
//	}
//	
//	//test that the isEmpty method returns false on a non-empty list
//	@Test
//	public void testIsNotEmpty(){
//		assertFalse(listA.isEmpty());
//	}
//	
//	//test that an empty list has size 0
//	@Test
//	public void testSizeEmpty(){
//		assertEquals(0, list.size());
//	}
//	
//	//test that a non-empty list has the right size
//	@Test
//	public void testSizeNonempty(){
//		assertEquals(listsize, listA.size());
//	}
//	
//	//test that the add method will change the size of the list appropriately
//	@Test
//	public void testAddAffectsSize(){
///*		ArrayList<String> list1 = new ArrayList<String>();
//		list1.add("Item");
//		list1.add("Thing");
//		list1.add("Stuff");
//		assertEquals(3, list1.size());*/
//		list.add("Item");
//		list.add("Thing");
//		list.add("Stuff");
//		assertEquals(3, list.size());
//	}
//	
//	//test adding to a non-empty list & check how the size changes
//	@Test
//	public void testAddNonEmpty(){
//		/*ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("a", "b"));
//		list1.add("1");
//		list1.add("2");		
//		assertEquals(4, list1.size());*/
//		listA.add("1");
//		listA.add("2");
//		assertEquals(2 + listsize,listA.size());
//	}
//	
//	//test the get method on the first item of a list
//	@Test
//	public void testGetFirstItem(){
//		assertEquals("a", listA.get(0));
//	}
//	
//	//test the get method on an item in the middle of a list
//	@Test
//	public void testGetMiddleItem(){
//		assertEquals("b", listA.get(1));
//	}
//	
//	//test the get method on the last item in a list, using the size function
//	@Test
//	public void testGetLastItem(){
//		assertEquals("f", listA.get(listA.size()-1));
//		
//	}
//	
//	//test that we can get an item that was added at the expected index
//	@Test
//	public void testGetAddedItem(){
//		list.add("Item");
//		list.add("Thing");
//		list.add("Stuff");
//		assertEquals("Item", list.get(0));
//		assertEquals("Thing", list.get(1));
//	}
//	
//	//test that we can get the last added item
//	@Test
//	public void testGetLastAddedItem(){
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//		assertEquals("d", list.get(list.size() - 1));
//	}
//	
//	/*Testing the add(int i) method*/
//	
//	//test that the add at index i method affects the size in the expected way
//	@Test
//	public void testAddAtIndexAffectsSize(){
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add(1,"d");
//		assertEquals(4, list.size());
//	}
//	
//	//test that adding at index i will set the entry to the right thing
//	@Test
//	public void testAddAtIndexi(){		
//		listA.add(3, "1");		
//		assertEquals(listA.get(3), "1");
//	}
//	
//	//test that the entries at lower indices stay the same
//	@Test
//	public void testAddAtIndexBelow(){		
//		listA.add(3, "1");
//		
//		for(int i = 0; i < 3; i++)
//			assertEquals(listA.get(i), listC.get(i));
//	}
//	
//	//test that the entries at higher indices stay the sam
//	@Test
//	public void testAddAtIndexAbove(){
//		listA.add(3, "1");
//		
//		for (int i = 4; i < listA.size(); i++)
//			assertEquals(listA.get(i), listC.get(i-1));
//	}
//	
//	/*Testing the set(int i, E) method*/
//	
//	//test that the set method affects the size as expected
//	@Test
//	public void testSetAtIndexAffectsSize(){
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.set(1,"d");
//		assertEquals(3, list.size());
//	}
//	
//	//test that the entry at index i changes as expected
//	@Test
//	public void testSetAtIndexi(){
//		listA.set(3, "1");
//		
//		assertEquals(listA.get(3),"1");
//	}
//	
//	//test that the entries at lower indices stay the same
//	@Test
//	public void testSetAtIndexBelow(){
//		listA.set(3, "1");
//		
//		for(int i = 0; i < 3; i++)
//			assertEquals(listA.get(i), listC.get(i));
//	}
//	
//	//test that the entries at higher indices stay the same
//	@Test
//	public void testSetAtIndexAbove(){
//		listA.set(3, "1");
//
//		for (int i = 4; i < listA.size(); i++)
//			assertEquals(listA.get(i), listC.get(i));
//	}
//	
//	/*Tests for the remove method*/
//	
//	//test that remove decreases the size by 1
//	@Test
//	public void testRemoveAffectsSize(){
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.remove(1);
//		assertEquals(2,list.size());
//	}
//	
//	//test the index where the item was removed to check that it is no longer there
//	@Test
//	public void testRemoveAtIndexi(){
//		listA.remove(3);
//		assertNotEquals(listA.get(3),"d");
//	}
//	
//	//test that the items below that index have stayed put
//	@Test
//	public void testRemoveAtIndexBelow(){
//		listA.remove(3);
//
//		for(int i = 0; i < 3; i ++)
//			assertEquals(listA.get(i), listC.get(i));
//	}
//	
//	//test that the items above that index have moved down by one
//	@Test
//	public void testRemoveAtIndexAbove(){
//		listA.remove(3);
//
//		for(int i = 3; i < listA.size(); i ++)
//			assertEquals(listA.get(i), listC.get(i+1));
//	}
//	
//	//test if we remove the first item in a list
//	@Test
//	public void testRemoveFirstItem(){
//
//		listA.remove(0);
//		
//		for(int i = 0; i < listA.size(); i++)
//			assertEquals(listA.get(i), listD.get(i));
//		
//	}
//	
//	//test if we remove the last item in a list
//	@Test
//	public void testRemoveLastItem(){
//		listA.remove(listA.size()-1);
//		
//		for(int i = 0; i < listA.size(); i++)
//			assertEquals(listA.get(i), listE.get(i));
//		
//	}
//	
//	/*Testing the contains(E) method*/
//	
//	@Test
//	public void testContainsYes(){
//		assertTrue(listA.contains("a"));
//	}
//	
//	@Test
//	public void testContainsNo(){
//		assertFalse(listA.contains("y"));
//	}
//	
//	//test that adding an item will change the result of contains
//	@Test
//	public void testAddContains(){
//		listA.add("y");
//		assertTrue(listA.contains("y"));
//	}
//	
//	//test that removing an item will change the result of contains
//	@Test
//	public void testRemoveContains(){
//		listA.remove(1);
//		assertFalse(listA.contains("b"));
//	}
//	//change to allow commit to repo
//
//
//}
//
