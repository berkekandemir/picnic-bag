package PicnicBagApp;
import java.util.*;

public class PicnicBagApp<T> { //in main, again we have unsolved errors. we really worked hard on them but could not figure them out. we will try to simply explain what we tried to do here. firstly we created objects to access to public methods in other classes. 
	private static Scanner keyboard = new Scanner(System.in);
	private static FileIO fileIO = new FileIO();
	private static IBag<String>[] OrganicTrashBag = new IBag<String>[](); // we created interface objects because some methods want them as parameters
	private static OrganicTrashBag<String> organicTrashBag = new OrganicTrashBag<String>();
	private static IBag<String>[] PaperTrashBag = new IBag<String>[]();
	private static PaperTrashBag<String> paperTrashBag = new PaperTrashBag<String>();
	private static PicnicBag<String> picnicBag = new PicnicBag<String>();
	private static IBag<String>[] PlasticTrashBag = new IBag<String>[]();
	private static PlasticTrashBag<String> plasticTrashBag = new PlasticTrashBag<String>();
	private static InventoryBag<String> inventoryBag = fileIO.readInventory();
	static String selection;
	
	public static void main(String[] args) {
		System.out.println("You have these items in your inventory: ");
		inventoryBag.displayItems();
		while (selection != "quit") { // we use user inputs and according to them remove from inventory and add to picnic bag. lastly show the picnic bag to user.
			System.out.println("To select an item, please enter its name. Then, It will be added to your picnic bag.");
			System.out.println("To quit, enter 'quit'.");
			selection = keyboard.next();
			picnicBag.add(selection);
			inventoryBag.remove(selection);
			System.out.println("This is your picnic bag: ");
			picnicBag.displayItems();
		}
		selection = null;
		while (selection != "quit") { // on the second stage, we give user a chance to remove items from picnic bag before picnic. we use the same procedure as before.
			System.out.println("This is your inventory bag: ");
			inventoryBag.displayItems();
			System.out.println("To remove item, please enter its name. Then It will be removed from your picnic bag.");
			System.out.println("To quit, enter 'quit'.");
			selection = keyboard.next();
			picnicBag.remove(selection);
			inventoryBag.add(selection);
			System.out.println("This is your picnic bag: ");
			picnicBag.displayItems();
		}
		selection = null;
		while (selection != "quit") { // on last stage, we go on a picnic. there, we just consume or remove items. we don't have a choice to add new items.
			System.out.println("You are ready to go on the picnic.");
			System.out.println("To eat or use anything, just enter 'consume'.");
			System.out.println("To remove enything, just enter 'remove'.");
			System.out.println("To quit, enter 'quit'.");
			selection = keyboard.next();
			if (selection == "consume") {
				System.out.println("This is your picnic bag: ");
				picnicBag.displayItems();
				selection = null;
				System.out.println("To consume something, enter its name.");
				selection = keyboard.next();
				String type = inventoryBag.findType(selection); // we find the type of the item and then throw it into its trash bag. we use here our extra method and consume method together. 
				if (type == "Organic") {
					picnicBag.consume(selection, OrganicTrashBag);
				} else if (type == "Paper") {
					picnicBag.consume(selection, PaperTrashBag);
				} else if (type == "Plastic") {
					picnicBag.consume(selection, PlasticTrashBag);
				}
			} else if (selection == "remove") { // if user wants to remove something, we use the same procedure to remove item.
				selection = null;
				System.out.println("To consume something, enter its name.");
				selection = keyboard.next();
				picnicBag.remove(selection);
			} else {
				System.out.println("Invalid entry!");
			} 
			System.out.println("This is your picnic bag: ");
			picnicBag.displayItems();
		}
		System.out.println("Organic trash count is: "); // lastly we show user his history. item counts and their types. then we clear all bags for another picnic.
		organicTrashBag.getItemCount();
		System.out.println("Organic trashes are: ");
		organicTrashBag.displayItems();
		organicTrashBag.dump();
		System.out.println("Plastic trash count is: ");
		plasticTrashBag.getItemCount();
		System.out.println("Plastic trashes are: ");
		plasticTrashBag.displayItems();
		plasticTrashBag.dump();
		System.out.println("Paper trash count is: ");
		paperTrashBag.getItemCount();
		System.out.println("Paper trashes are: ");
		paperTrashBag.displayItems();
		paperTrashBag.dump();
		picnicBag.dump();
		
	}

}
