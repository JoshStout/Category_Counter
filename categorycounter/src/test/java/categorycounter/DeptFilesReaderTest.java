package categorycounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class DeptFilesReaderTest {

	@Test
	void testConstructor() {
		CategoriesReader reader = new CategoriesReader();
		assertNotNull(reader);
	}

	@Test
	void testPrintFiles() {
		CategoriesReader reader = new CategoriesReader();
		ItemsArr items = reader.readFiles();
		assertNotNull(items);
//		items.printArray();
	}
	
	@Test
	void testGetDepts() {
		CategoriesReader reader = new CategoriesReader();
		reader.readFiles();
		String[] depts = new String[reader.getCount()];
		depts = reader.getCategory();
//		for(int i = 0; i < depts.length; i++) {
//			System.out.println(depts[i]);
//		}
	}
	
	@Test
	void testGetDeptMap() {
		CategoriesReader reader = new CategoriesReader();
		reader.readFiles();
//		System.out.println(reader.getDeptMap().toString());
		HashMap<String, Integer> map = new HashMap<>();
		map = reader.getCategoriesMap();
		assertEquals(0, map.get("Category2"));
		assertNotEquals(1, map.get("Category1"));
	}
	
}
