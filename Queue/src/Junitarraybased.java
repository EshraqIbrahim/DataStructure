import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author user
 *
 */
public class Junitarraybased {
	/**
	 * @author user
	 *
	 */
	public static final int T = 7;
	/**
	 * @author user
	 *
	 */
	public static final int F = 5;

	/**
	 * @author user
	 *
	 */
	@Test
	public void testenqueuedequeue() {
		Arrayed x = new Arrayed(T);
		x.enqueue(T);
		x.enqueue(F);
		x.enqueue(F);
		Assert.assertEquals(T, x.dequeue());
		Assert.assertEquals(F, x.dequeue());
		Assert.assertEquals(F, x.dequeue());
		Assert.assertEquals(true, x.isEmpty());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testsize() {
		Arrayed x = new Arrayed(T);
		x.enqueue(F);
		x.enqueue(F);
		x.enqueue(F);
		x.enqueue(F);
		x.enqueue(F);
		Assert.assertEquals(F, x.size());
		x.dequeue();
		x.dequeue();
		x.dequeue();
		x.dequeue();
		x.dequeue();
		Assert.assertEquals(0, x.size());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testcircular() {
		Arrayed x = new Arrayed(F);
		x.enqueue(F);
		x.enqueue(T);
		x.enqueue(F);
		x.enqueue(T);
		x.enqueue(F);
		x.dequeue();
		x.dequeue();
		x.enqueue(T);
		Assert.assertEquals(F, x.dequeue());
		Assert.assertEquals(T, x.dequeue());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void empty() {
		Arrayed x = new Arrayed(F);
		x.enqueue(T);
		x.dequeue();
		Assert.assertEquals(true, x.isEmpty());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testemptydequeue() {
		Arrayed x = new Arrayed(F);
		Boolean thrown = false;
		x.enqueue(T);
		x.dequeue();
		try {
			x.dequeue();
		} catch (NullPointerException exception) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testfullqueue() {
		Arrayed x = new Arrayed(F);
		Boolean thrown = false;
		x.enqueue(F);
		x.enqueue(F);
		x.enqueue(F);
		x.enqueue(F);
		x.enqueue(F);
		try {
			x.enqueue(F);
		} catch (NullPointerException exception) {
			thrown = true;
		}
		assertTrue(thrown);
	}
}

