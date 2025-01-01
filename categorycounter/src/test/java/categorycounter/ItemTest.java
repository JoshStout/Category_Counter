package categorycounter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void testConstructor() {
		Item item = new Item("test");
		assertNotNull(item);
	}
	
	@Test
	void testOne() {
		Item one = new Item("one");
		one.setCategory("a");
		assertEquals("one", one.getItem());
		assertEquals("a", one.getCategory());
		assertNotEquals("two", one.getItem());
	}

}
