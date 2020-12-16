package PicnicBagApp;

public interface IBag<T> { // we created the interface for the subject so that we can use bag interface with different kind of bags
	public boolean add(T newItem);
	public boolean isEmpty();
	public boolean isFull();
	public T removeByIndex(int index);
	public T remove();
	public T remove(T item);
	public int getItemCount();
	public int getIndexOf(T item);
	public boolean contains(T item);
	public void displayItems();
	public void dump();
	public boolean transferTo(IBag<T>[] targetBag, T item);
}
