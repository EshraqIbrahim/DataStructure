

/**
 * @author user
 *
 */
public class Arrayed implements IQueue, IArrayBased {
	/**
	 * @author user
	 *
	 */
	public int first = -1;
	/**
	 * @author user
	 *
	 */
	public int last = -1;
	/**
	 * @author user
	 *
	 */
	public int size = 0;
	/**
	 * @author user
	 *
	 */
	public int sizequeuee;

	/**
	 * @author user
	 * @param sizequeue take size
	 *
	 */
	Arrayed(final int sizequeue) {
		x = new Object[sizequeue];
		this.sizequeuee = sizequeue;
	}

	/**
	 * @author user
	 *
	 */
	public Object[] x = new Object[sizequeuee];

	/**
	 * @author user
	 * @return tag
	 *
	 */
	public boolean full() {
		return ((first == last && last != -1 && first != -1)
				|| (first == -1 && last == (x.length - 1)));
	}

	@Override
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		if (this.full()) {
			throw null;
		}
		last = (last + 1) % x.length;
		x[last] = item;
		size++;

	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			throw null;
		}
		first = (first + 1) % x.length;
		Object z = x[first];
		if (first == last) {
			first = -1;
			last = -1;
		}
		size--;
		return z;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == -1 && last == -1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}

