package categorycounter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

class SubstringFinderTest {

	@Test
	void testGetItems() {
		
		// this adds the csv file to a 2d array
		CSVFileReader csvReader = new CSVFileReader();
		String[][] csvArray = csvReader.readFile("src/main/resources/test.csv");
		
		// this reads each department file and adds each item to an array
		CategoriesReader deptReader = new CategoriesReader();
		ItemsArr items = deptReader.readFiles();
		
		// this creates a HashMap with zero values for each department
		HashMap<String, Integer> map = new HashMap<>();
		map = deptReader.getCategoriesMap();
		
		SubstringFinder sf = new SubstringFinder(csvArray, map, items, 4);
		String cell = "item1 item2 item3";
		List<Item> list = new ArrayList<Item>();
		list = sf.getItems(cell);
		for(Item i : list) {
//			System.out.println(i.getItem());
		}
	}
	
	@Test
	void testGetAllItems() {
		
		// this adds the csv file to a 2d array
		CSVFileReader csvReader = new CSVFileReader();
		String[][] csvArray = csvReader.readFile("src/main/resources/test.csv");
		
		// this reads each department file and adds each item to an array
		CategoriesReader deptReader = new CategoriesReader();
		ItemsArr items = deptReader.readFiles();
		
		// this creates a HashMap with zero values for each department
		HashMap<String, Integer> map = new HashMap<>();
		map = deptReader.getCategoriesMap();
		
		SubstringFinder sf = new SubstringFinder(csvArray, map, items, 4);
		List<Item> list = new ArrayList<Item>();
		list = sf.getAllItems();
		for(Item i : list) {
//			System.out.println(i.getItem());
		}
	}
	
	@Test
	void testGetDeptCount() {
		
		// this adds the csv file to a 2d array
		CSVFileReader csvReader = new CSVFileReader();
		String[][] csvArray = csvReader.readFile("src/main/resources/test.csv");
		
		// this reads each department file and adds each item to an array
		CategoriesReader deptReader = new CategoriesReader();
		ItemsArr items = deptReader.readFiles();
		
		// this creates a HashMap with zero values for each department
		HashMap<String, Integer> map = new HashMap<>();
		map = deptReader.getCategoriesMap();
		
		SubstringFinder sf = new SubstringFinder(csvArray, map, items, 4);
		HashMap<String, Integer> deptMap = new HashMap<>();
		deptMap = sf.getCategoriesCount();
//		System.out.println(deptMap.toString());
	}

}
