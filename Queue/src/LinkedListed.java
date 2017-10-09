
import java.util.LinkedList;


/**
 * @author user
 *
 */
public class LinkedListed implements IQueue, ILinkedBased {
	/**
	 * @author user
	 *
	 */
	LinkedList<Object> list = new LinkedList<Object>();
	/**
	 * @author user
	 *
	 */
	public int size = 0;

	@Override
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		if (item == null) {
			return;
		}
		list.addLast(item);
		size++;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (list.isEmpty()) {
			throw null;
		}
		Object x;
		x = list.getFirst();
		list.removeFirst();
		size--;
		return x;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		int z = list.size();
		return z == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

}

