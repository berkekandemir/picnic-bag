package PicnicBagApp;

public class Item { // in this class we have problems that we cannot solve. we could not come to you in your office hours, so we could not asky you and could not solve on our own or via internet.
	// also to be honest, we couldn't understand what these two methods do actually.
	private FileIO fileIO = new FileIO();
	private InventoryBag<String> inventoryBag = fileIO.readInventory();
	
	public String toString() { // we thought this method is to print out the items and designed it like that but we cannot solve the problem.
		for (int i = 0; i <  inventoryBag.length; i++) {
			for (String i : inventoryBag) {
				String[] nameNType = ((String) i).split(",");
				System.out.println(nameNType[0]);
			}
		}
	}
	
	public boolean equals(Object obj) { // in this method we designed it to compare items with the user entry. it checks every item in the bag with the input
		for (int i = 0; i < inventoryBag.length; i++) {
			for (String i : inventoryBag) {
				String[] nameNType = ((String) i).split(",");
				if (obj == nameNType[0]) {
					return true;
				}
			}
		return false;
}
