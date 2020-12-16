package PicnicBagApp;
import java.io.*;
import java.util.*;

public class FileIO {
	private InventoryBag<String> inventoryBag = new InventoryBag<String>(); //At first, we created an inventoryBag object to return from the method 
	private int count = 0; // we use count to specify the length of the text file
	public InventoryBag<String> readInventory(){
		Scanner line = null; // we used scanner to read the file as shown in the slides
		
		try {
			line = new Scanner(new File("CENG112_Homework1_Bags_Inventory.txt"));
			while (line.hasNextLine()){
	        	count += 1;
			}
		}
        	
        catch (FileNotFoundException e) {
        	System.out.println("File Not Found!");
		}
		
		String[] products = new String[count]; // we put the informations in arrays to store and use again
		String[] types = new String[count];
		int[] amounts = new int[count];
		
		try {
			line = new Scanner(new File("CENG112_Homework1_Bags_Inventory.txt"));
			for (int i = 0; i < count; i++){ // As shown in the slides we can read the text with scanner by next commands
				String product = line.next();
	        	String type = line.next();
	        	int amount = line.nextInt();
	        	products[count] = product;
	        	types[count] = type;
	        	amounts[count] = amount;
			}
		}
        	
        catch (FileNotFoundException e) { // if the file is not there, it throws exception to warn the user
        	System.out.println("File Not Found!");
		}
		for (int i = 0; i < amounts.length; i++) { // with these block, we created items that has product and type name for its amount time, then add them into inventory bag.
			for (int j = 0; j < amounts[i]; j++) {
				String item = products[i] + "," + types[i]; // we used comma as separator to split easily when we used them
				inventoryBag.add(item);
			}
		}
		
		
		return inventoryBag;
	}
}