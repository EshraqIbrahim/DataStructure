import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author user
 *
 */
public class JunitLinkedTest {
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
		LinkedListed x = new LinkedListed();
		x.enqueue(F);
		x.enqueue(F);
		x.enqueue(T);
		Assert.assertEquals(F, x.dequeue());
		Assert.assertEquals(F, x.dequeue());
		Assert.assertEquals(T, x.dequeue());
		Assert.assertEquals(true, x.isEmpty());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testsize() {
		LinkedListed x = new LinkedListed();
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
		LinkedListed x = new LinkedListed();
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
		Assert.assertEquals(F, x.dequeue());
		Assert.assertEquals(T, x.dequeue());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void empty() {
		LinkedListed x = new LinkedListed();
		x.enqueue(F);
		x.dequeue();
		Assert.assertEquals(true, x.isEmpty());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testdequeueempty() {
		LinkedListed x = new LinkedListed();
		Boolean thrown = false;
		x.enqueue(F);
		x.dequeue();
		try {
			x.dequeue();
		} catch (NullPointerException exception) {
			thrown = true;
		}

		assertTrue(thrown);
	}

}
