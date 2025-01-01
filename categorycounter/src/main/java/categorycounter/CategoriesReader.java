package categorycounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CategoriesReader {
	
	private String[] categories;
	private int count;
	
	/**
	 * Creates a new object to read all the files within
	 * src/main/resources/categories folder and places them into
	 * an ItemsArr object.
	 */
	public CategoriesReader() {
		categories = new String[] {};
		count = 0;
	}
	
	/**
	 * A getter to provide an array of Strings representing 
	 * all the category, which is taken from the filenames
	 * @return An array of Strings representing all the category
	 */
	public String[] getCategory() {
		return categories;
	}
	
	/**
	 * A method to get the number of category found in 
	 * the resources folder
	 * @return A integer representing the number of category
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Creates a HashMap where the key is each category and the value are 
	 * initialized to zero.
	 * @return A HashMap of each category and each value is set to 0
	 */
	public HashMap<String, Integer> getCategoriesMap(){
		HashMap<String, Integer> catMap = new HashMap<>();
		for(int i = 0; i < categories.length; i++) {
			catMap.put(categories[i], 0);
		}
		return catMap;
	}
	
	/**
	 * A helper method to insert each filename into an Array of Strings
	 * @param str An array of Strings containing each category
	 */
	private void insertCategory(String str) {
		if(categories.length == count) {
			String[] newCat = new String[count + 1];
			for(int i = 0; i < count; i++) {
				newCat[i] = categories[i];
			}
			categories = newCat;
		}
		categories[count++] = str;
	}
	
	/**
	 * Goes through each file saved in
	 * src/main/resources/categories
	 * and adds each word saved on its own line
	 * as an Item object in an ItemsArray object.
	 * @return An ItemsArray object
	 */
	public ItemsArr readFiles() {
		File dir = new File("src/main/resources/categories");
		File[] directoryListing = dir.listFiles();
		ItemsArr itemsArray = new ItemsArr();
		if(directoryListing != null) {
			itemsArray = fileIterator(directoryListing);
		} else {
			// handlers here 
		}
		return itemsArray;
	}
	
	/**
	 * Iterates thru each file within the folder as specified
	 * in the readFiles method while adding each filename 
	 * to the HashMap for each category.
	 * @param directoryListing File[] object containing the location of the categories folder
	 * @return An itemsArray object containing all the items found in each categories file
	 */
	private ItemsArr fileIterator(File[] directoryListing) {
		ItemsArr itemsArray = new ItemsArr();
		for(File child : directoryListing) {
			insertCategory(child.getName());
			try {
				Scanner sc = new Scanner(new File(child.toString()));
				sc.useDelimiter("\r\n");
				while(sc.hasNext()){
					Item item = new Item(sc.nextLine());
					item.setCategory(child.getName());
					itemsArray.insert(item);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return itemsArray;
	}
}
