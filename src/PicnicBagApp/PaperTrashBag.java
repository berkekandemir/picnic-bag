package PicnicBagApp;

public class PaperTrashBag<T> implements IBag<T> {
	private T[] paperTrashBag;
	private int size;
	@SuppressWarnings("unchecked")
	public PaperTrashBag() { //the array's type is generic here but we want it to store strings and we cannot create generic arrays. instead of this, we cast the array to generic type.
		paperTrashBag = (T[]) new String[size];
		size = 15;
	}
	public T[] getPaperTrashBag() {  //since our array and size are private, we use setter and getters to reach them
		return paperTrashBag;
	}

	public void setPaperTrashBag(T[] paperTrashBag) {
		this.paperTrashBag = paperTrashBag;
	}

	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean isFull() { // to find the emptiness, we iterate in the bag and we count the places that are not "null". then we compare our count and the actual size.
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (paperTrashBag[i] != null) {
				count += 1;
			}
		}
		if (count < size) {
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean add(T newItem) { // first we check emptiness then we start add process. we cannot mutate the array so to add something, we use temporary array. we copy the actual array into it and fill the first empty place with our item. if something happens unexpected, it throws exception.
		T[] tempArr = (T[]) new String[size]; // we use temporary array to add or remove items from arrays
		try {
			if (!isFull()) {
				for (int i = 0; i < size; i++) {
					if (paperTrashBag[i] == null) {
						tempArr[i] = newItem;
						break;
					} else {
						tempArr[i] = paperTrashBag[i];
					    tempArr = paperTrashBag;
					}   
				}
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean isEmpty() { // in this method, we are after "null" elements. if they occur in an array, that means our bag has empty space.
		for (int i = 0; i < size; i++) {
			if (paperTrashBag[i] == null) {
				return true;
			}
		}
			return false;
	}
	
	@SuppressWarnings("unchecked")
	public T removeByIndex(int index) { //we check the bag and the input if they are suitable or not. then we make the same thing. copy the array into temporary and skip the element which is in the specified index. then reference actual array to its point.
		T element = null;
		if (paperTrashBag == null || index < 0 || index >= paperTrashBag.length) { 
			return (T) paperTrashBag; 
		} 
	        T[] tempArray = (T[]) new String[paperTrashBag.length - 1]; 

	        for (int i = 0, j = 0; i < paperTrashBag.length; i++) { 
	            if (i == index) { 
	            	element = paperTrashBag[i];
	                continue; 
	            }
	            tempArray[j++] = paperTrashBag[i]; 
	        } 
	        tempArray = paperTrashBag;
	        return element; 
	    }
	  
	@SuppressWarnings("unchecked")
	public T remove() { // in this normal remove method, we remove the first element of the bag. the rest is the same with the one before.
		T element = null;
		if (paperTrashBag == null) { 
			return null; 
		} 
	        T[] tempArray = (T[]) new String[paperTrashBag.length - 1]; 

	        for (int i = 0, j = 0; i < paperTrashBag.length; i++) { 
	            if (i == 0) { 
	            	element = paperTrashBag[i];
	                continue; 
	            }
	            tempArray[j++] = paperTrashBag[i]; 
	        } 
	        tempArray = paperTrashBag;
	        return element; 
	} 
	
	@SuppressWarnings("unchecked")
	public T remove(T item) { // in this one, we chase the item name and skip it while copying. the rest is the same with the others. since we cannot use lists, we use arrays and to add or remove something we got to use these copying methods.
		if (paperTrashBag == null) { 
			return null; 
		} 
	        T[] tempArray = (T[]) new String[paperTrashBag.length - 1]; 

	        for (int i = 0, j = 0; i < paperTrashBag.length; i++) { 
	            if (paperTrashBag[i] == item) { 
	                continue; 
	            }
	            tempArray[j++] = paperTrashBag[i]; 
	        } 
	        tempArray = paperTrashBag;
	        return item; 
	    } 
	
	public int getItemCount() { // we take the length to find the item count
		return paperTrashBag.length;
	}
	
	@SuppressWarnings("unused")
	public int getIndexOf(T item) { // we chase the item name and return its index.
		for (int i = 0; i < paperTrashBag.length; i++) {
			if (paperTrashBag[i] == item) {
				return i;
			} else {
				try {
					T a = paperTrashBag[i + 1];
				} catch (Exception e) {
					System.out.println("Could not find the item!");
				}
			}
		}
		return -1;
	}
	
	public boolean contains(T item) { // we again chase the item name and if we find it, method returns true
		for (int i = 0; i < paperTrashBag.length; i++) {
			if (paperTrashBag[i] == item) {
				return true;
			} else if (i == paperTrashBag.length) {
				return false;
			}
		}
		return false;
	}
	
	public void displayItems() { // we iterate in the array and simply, print out the every element one by one to display on the screen
		for (int i = 0; i < paperTrashBag.length; i++) {
			System.out.println(paperTrashBag[i]);
		}
	}
	
	public void dump() { // to empty the array, we just assign it to null
		paperTrashBag = null;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public boolean transferTo(IBag<T>[] targetBag, T item) { // we simple catch the item name and assign it to the first empty space of the target bag
		try {
			for (int i = 0; i < targetBag.length; i++) {
				if (targetBag[i] == null) {
					targetBag[i] = (IBag<T>) item;
					return true;
				} else {
						return false;
			}
		}
	} catch (Exception e) {
			return false;
		}
		return false;
	}

}
