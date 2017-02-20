import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapTests {

	@Test
	public void createMap() {
		makeNewMap();
	}
	
	@Test
	public void newMapIsEmpty() {
		Map<String, String> m = makeNewMap();
		assertTrue(m.isEmpty());
	}
	
	@Test
	public void newMapIsSize0() {
		Map<String, String> m = makeNewMap();
		assertTrue(m.size() == 0);
	}

	@Test
	public void canAddItem() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
	}
	
	@Test
	public void addItemNonEmpty() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		assertFalse(m.isEmpty());
	}
	
	@Test
	public void add1stItemReturnsNull() {
		Map<String, String> m = makeNewMap();
		assertNull(m.put("hello", "world"));
	}
	
	@Test
	public void addItemSize1() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		assertTrue(m.size() == 1);
	}

	@Test
	public void canAdd2ndItem() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
	}
	
	@Test
	public void add2ndItemNotEmpty() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertFalse(m.isEmpty());
	}
	
	@Test
	public void add2ndItemSize2() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertTrue(m.size() == 2);
	}

	@Test
	public void add2ndItemReturnsNull() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		assertNull(m.put("goodnight", "moon"));
	}

	@Test
	public void canReplaceItem() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("hello", "there");
	}
	
	@Test
	public void replacedItemReturned() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		assertEquals("world",
				m.put("hello", "there"));
	}
	
	@Test
	public void replaceItem1SizeUnchanged() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("hello", "there");
		assertTrue(m.size() == 1);
	}

	@Test
	public void doubleReplacedItemReturned() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("hello", "there");
		assertEquals("there",
				m.put("hello", "goodbye"));
	}

	@Test
	public void containsKeyTrue() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertTrue(m.containsKey("hello"));
		assertTrue(m.containsKey("goodnight"));
	}
	
	@Test
	public void containsKeyFalse() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertFalse(m.containsKey("hi"));
	}
	
	@Test
	public void clear() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.clear();
	}
	
	@Test
	public void clearIsEmpty() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.clear();
		assertTrue(m.isEmpty());
	}
	
	@Test
	public void clearIsSize0() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.clear();
		assertTrue(m.size() == 0);
	}
	
	@Test
	public void clearAddIsSize1() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.clear();
		m.put("test", "ok");
		assertTrue(m.size() == 1);
	}
	
	@Test
	public void clearItemsGone() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.clear();
		assertFalse(m.containsKey("hello"));
		assertFalse(m.containsKey("goodnight"));
	}
	
	@Test
	public void canAddMany() {
		Map<Integer, String> m = makeNewMap();
		int x = 1;
		for (int i = 1; i <= 50; i++)
			m.put(x *= i, "ok");
	}
	
	@Test
	public void addManySize() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok");
		assertTrue(m.size() == 50);
	}
	
	@Test
	public void getExisting() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertEquals("world",m.get("hello"));
		assertEquals("moon",m.get("goodnight"));
	}
	
	@Test
	public void getNonExisting() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertNull(m.get("hi"));
	}	
	
	@Test
	public void removeExisting() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.remove("hello");
	}
	
	@Test
	public void removeExistingReturned1() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertEquals("world",
				m.remove("hello"));
	}
	
	@Test
	public void removeExistingReturned2() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertEquals("moon",
				m.remove("goodnight"));
	}
	
	@Test
	public void removeExistingSize() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.remove("hello");
		assertTrue(m.size() == 1);
	}
	
	@Test
	public void removeNonExisting() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertNull(m.remove("hi"));
	}
	
	@Test
	public void removeNonExistingSize() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.remove("hi");
		assertTrue(m.size() == 2);
	}
		
	@Test
	public void removeAllEmpty() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		m.remove("hello");
		m.remove("goodnight");
		assertTrue(m.isEmpty());
	}

	@Test
	public void addManyContainsKeyFalse() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok");
		assertFalse(m.containsKey(0));
		assertFalse(m.containsKey(24));
		assertFalse(m.containsKey(25*26/2-1));
	}
	
	@Test
	public void addManyContainsKeyTrue() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok");
		assertTrue(m.containsKey(15));
		assertTrue(m.containsKey(25*26/2));
		assertTrue(m.containsKey(50*51/2));
	}

	@Test
	public void addManyContainsAll() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok");
		x = 0;
		for (int i = 1; i <= 50; i++)
			assertTrue(m.containsKey(x += i));
	}
	@Test
	public void addManyGet() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok " + i);
		assertEquals("ok 34",
				m.get(34 * 35 / 2));
		assertEquals("ok 1",
				m.get(1));
		assertEquals("ok 50",
				m.get(50 * 51 / 2));
	}
		
	@Test
	public void addManyRemove() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok " + i);
		assertEquals("ok 34",
				m.remove(34*35/2));
	}
	
	@Test
	public void addManyRemoveSize() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok " + i);
		m.remove(34*35/2);
		m.remove(1);
		assertTrue(m.size() == 48);
	}

	@Test
	public void addManyRemovedNotContained() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok " + i);
		m.remove(34);
		m.remove(1);
		assertFalse(m.containsKey(34));
	}	

	@Test
	public void addManyRemoveMany() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(i, "ok " + i);
		assertTrue(m.size() == 50);
		x = 1;
		for (int i = 0; i < 35; i++)
			m.remove(x = (x * 7 + 1) % 51);
		x = 1;
		for (int i = 0; i < 35; i++)
			assertFalse(m.containsKey(x = (x * 7 + 1) % 51));
	}	

	@Test
	public void containsValue() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertTrue(m.containsValue("world"));
		assertTrue(m.containsValue("moon"));
	}
	
	@Test
	public void addManyContainsValue() {
		Map<Integer, String> m = makeNewMap();
		int x = 0;
		for (int i = 1; i <= 50; i++)
			m.put(x += i, "ok " + i);
		x = 0;
		for (int i = 1; i <= 50; i++)
			assertTrue(
					m.containsValue("ok " + i));
	}

	@Test
	public void keySet() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertNotNull(m.keySet());
	}

	@Test
	public void keySetIterable() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		for (String k : m.keySet())
			assertNotNull(k);
	}

	@Test
	public void entrySet() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		assertNotNull(m.entrySet());
	}

	@Test
	public void entrySetIterable() {
		Map<String, String> m = makeNewMap();
		m.put("hello", "world");
		m.put("goodnight", "moon");
		for (Map.Entry<String, String> e
				: m.entrySet())
			assertEquals(m.get(e.getKey()),
					e.getValue());
	}

	private <K,V> Map<K,V> makeNewMap() {
		return new HashMap<K,V>();
	}

}
