package categorycounter;

import java.util.HashMap;
import java.util.Scanner;

public class Worker {
	
	public Worker(String file) {
		
		System.out.println("Input which column to search and hit 'Enter'");
		Scanner reader = new Scanner(System.in);
		int column = reader.nextInt(); 
		reader.close();
		
		// this adds the csv file to a 2d array
		CSVFileReader csvReader = new CSVFileReader();
		String[][] csvArray = csvReader.readFile(file);
		
		// this reads each department file and adds each item to an array
		CategoriesReader catReader = new CategoriesReader();
		ItemsArr items = catReader.readFiles();
		
		// this creates a HashMap with zero values for each department
		HashMap<String, Integer> map = new HashMap<>();
		map = catReader.getCategoriesMap();
		
		SubstringFinder sf = new SubstringFinder(csvArray, map, items, column);
		HashMap<String, Integer> catMap = new HashMap<>();
		catMap = sf.getCategoriesCount();
		System.out.println(catMap.toString());
		
	}
	
}
