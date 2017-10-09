
import javax.management.RuntimeErrorException;

/**
 * @author user
 *
 */
public class SingleList implements ILinkedList {
	/**
	 * @author user
	 *
	 */
	public Nodee head = null;

	/**
	 * @author user
	 *
	 */
	public void print() {
		Nodee current = head;
		while (current != null) {
			System.out.print(current.data);
			current = current.next;
		}
	}

	@Override
	public void add(final int index, final Object element) {
		Nodee newNode = new Nodee(element);
		if (index < 0) {
			throw new RuntimeErrorException(null);
		}
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Nodee current = head;
			for (int i = 0; i < index - 1; i++) {
				if (current.next == null) {
					throw new RuntimeErrorException(null);
				}
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;

			// TODO Auto-generated method stub
		}
	}

	@Override
	public void add(final Object element) {
		// TODO Auto-generated method stub
		Nodee newNode = new Nodee(element);
		Nodee current = head;
		if (head == null) {
			head = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			newNode.next = null;
			current.next = newNode;

		}
	}

	@Override
	public Object get(final int index) {
		// TODO Auto-generated method stub
		Nodee current = head;
		if (index < 0) {
			throw new RuntimeErrorException(null);
		}
		if (head == null) {
			throw new RuntimeErrorException(null);
		}
		if (index == 0) {
			return head.data;
		}
		for (int i = 0; i < index - 1; i++) {
			if (current.next == null) {
				throw new RuntimeErrorException(null);
			}
			current = current.next;
		}
		if (current.next == null) {
			throw new RuntimeErrorException(null);
		}
		return current.next.data;
	}

	@Override
	public void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		Nodee newNode = new Nodee(element);
		if (index < 0) {
			throw new RuntimeErrorException(null);
		}
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Nodee current = head;
			for (int i = 0; i < index - 1; i++) {
				if (current.next == null) {
					throw new RuntimeErrorException(null);
				}
				current = current.next;
			}
			newNode.next = current.next.next;
			current.next = newNode;
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	@Override
	public void remove(final int index) {
		// TODO Auto-generated method stub
		if (index < 0) {
			throw new RuntimeErrorException(null);
		}
		if (index == 0) {
			head = head.next;

		} else {
			Nodee current = head;
			for (int i = 0; i < index - 1; i++) {
				if (current.next == null) {
					throw new RuntimeErrorException(null);
				}
				current = current.next;
			}
			current.next = current.next.next;

		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int counter = 0;
		if (head == null) {
			return 0;
		} else {
			Nodee current = head;
			while (current != null) {
				counter++;
				current = current.next;
			}
		}
		return counter;
	}

	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex < 0 || toIndex < 0
				|| fromIndex > size() || toIndex > size()) {
			throw null;
		}

		SingleList sub = new SingleList();
		for (int i = fromIndex; i <= toIndex; i++) {
			sub.add(get(i));
		}
		return sub;
	}

	@Override
	public boolean contains(final Object o) {
		// TODO Auto-generated method stub
		if (o.equals(null)) {
			throw new RuntimeErrorException(null);
		}
		if (head == null) {
			throw new RuntimeErrorException(null);
		} else {
			Nodee current = head;
			while (current != null) {
				if (current.data.equals(o)) {
					return true;
				}
				current = current.next;
			}
		}
		return false;

	}

}
