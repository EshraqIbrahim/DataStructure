package stack;

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
	public int counter;

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
			head.next = null;
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
			return current.data;
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
		} else if (index == 0) {
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

}

