package categorycounter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemsArrayTest {
	
	@Test
	void testConstructor() {
		Item item = new Item("test");
		assertNotNull(item);
	}
	
	@Test
	void testOne() {
		Item one = new Item("one");
		one.setCategory("a");
		ItemsArr items = new ItemsArr();
		items.insert(one);
		assertEquals(1, items.getSize());
		Item[] arr = items.getArray();
		assertEquals("one", arr[0].getItem());
		assertEquals("a", arr[0].getCategory());
	}

}
