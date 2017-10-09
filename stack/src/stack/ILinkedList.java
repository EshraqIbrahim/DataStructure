package stack;


/**
 * @author user
 *
 */
public interface ILinkedList {
	/**
	 * Inserts a specified element at the specified sposition in the list.
	 */
	/**
	 * @param index capitalize whatver
	 * @param element capitalize whadfhjtver
	 *
	 */
	public void add(int index, Object element);

	/** Inserts the specified element at the end of the list. */
	/**
	 * @param element capitalize whatver
	 *
	 */
	public void add(Object element);

	/** Returns the element at the specified position in this list. */
	/**
	 * @param index capitalize whatver
	 * @return tag
	 *
	 */
	public Object get(int index);

	/** Removes all of the elements from this list. */
	public void clear();

	/** Returns true if this list contains no elements. */
	/**
	 * @return tag
	 *
	 */
	public boolean isEmpty();

	/** Removes the element at the specified position in this list. */
	/**
	 * @param index capitalize whatver
	 *
	 */
	public void remove(int index);
}

