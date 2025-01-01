package categorycounter;

public class Item implements Comparable<Item> {
	
	private String item;
	private String cat;
	
	/**
	 * Takes in a single String of items and the
	 * getItems method returns an array of items,
	 * each item as a separate element in the array. 
	 * @param item
	 */
	public Item(String item) {
		this.item = item;
	}
	
	/**
	 * A modifier that adds a department name to the item
	 * @param category A String representing the department
	 */
	public void setCategory(String category) {
		this.cat = category;
	}
	
	/**
	 * A getter that returns the department for the item
	 * @return A String that represents the department 
	 */
	public String getCategory() {
		return cat;
	}
	
	/**
	 * A getter that returns the item
	 * @return An Item object that represents the item
	 */
	public String getItem() {
		return item;
	}
	
	/**
	 * Override method to compare two Item objects
	 */
	public int compareTo(Item i) {
		Item item = (Item) i;
		if(this.equals(item)) return 0;
		return this.getItem().compareTo(item.getItem());
	}

}
