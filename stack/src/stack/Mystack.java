package stack;


/**
 * @author user
 *
 */
public class Mystack implements IStack {
	/**
	 * @author user
	 *
	 */
	SingleList list = new SingleList();
	/**
	 * @author user
	 *
	 */
	public int size = 0;

	@Override
	public void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		SingleList temp = new SingleList();
		int tempsize = 0;
		if (size == 0 && index == 0) {
			push(element);
			return;
		}
		if (size + 1 < index) {
			throw null;
		}
		for (int i = size - 1; i >= index; i--) {
			temp.add(pop());
			tempsize++;

		}
		push(element);

		for (int j = tempsize - 1; j >= 0; j--) {
			push(temp.get(j));

		}
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw null;
		}
		Object i = list.get(0);
		list.remove(0);
		size--;
		return i;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw null;
		}
		Object i = list.get(0);
		return i;
	}

	@Override
	public void push(final Object element) {
		// TODO Auto-generated method stub
		list.add(0, element);
		size++;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean test = list.isEmpty();
		return test;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}

