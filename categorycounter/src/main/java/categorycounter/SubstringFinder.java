package categorycounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringFinder {
	
	String[][] csvArr;
	HashMap<String, Integer> map;
	ItemsArr items;
	int column;
	
	/**
	 * An object used to find how many of each Items belong to what department.
	 * @param csvArr A 2D array representing the CSV file to scan
	 * @param map A HashMap that contains each department 
	 * @param items An ItemsArr object containing all Item objects
	 * @param column The column of the CSV file to scan
	 */
	public SubstringFinder(String[][] csvArr, HashMap<String, Integer> map, ItemsArr items, int column) {
		this.csvArr = csvArr;
		this.map = map;
		this.items = items;
		this.column = column;
	}
	
	/**
	 * Returns a list of Items found within a single String
	 * @param Cell The String contained within the CSV cell
	 * @return A list of each Item object found in the String
	 */
	public List<Item> getItems(String cell) {
		Item[] arr = items.getArray();
		List<Item> list = new ArrayList<Item>();
		for(int i = 0; i < arr.length; i++) {
			if(cell.contains(arr[i].getItem())) {
				list.add(arr[i]);
			}
		}		
		return list;
	}
	
	/**
	 * Returns a list of all Items for the entire column
	 * @return List of all Items found in the entire column
	 */
	public List<Item> getAllItems(){
		List<Item> list = new ArrayList<Item>();
		for(int i = 0; i < csvArr.length; i++) {
			String cell = csvArr[i][column];
			list.addAll(getItems(cell.toLowerCase()));
		}
		return list;
	}
	
	/**
	 * Returns a HashMap where the key is the category and the value
	 * is the number of Items belonging to that category.
	 * @return A HashMap where key = category and value = count
	 */
	public HashMap<String, Integer> getCategoriesCount(){
		List<Item> list = new ArrayList<Item>();
		list = getAllItems();
		HashMap<String, Integer> categoryMap = new HashMap<>();
		if(map != null) {
			categoryMap.putAll(map);
			for(Item i : list) {
				categoryMap.put(i.getCategory(), categoryMap.get(i.getCategory()) + 1);
			}
		}
		return categoryMap;
	}
}
