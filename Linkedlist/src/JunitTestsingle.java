import static org.junit.Assert.assertTrue;

import javax.management.RuntimeErrorException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author user
 *
 */
public class JunitTestsingle {
	/**
	 * @author user
	 *
	 */
	public static final int T = 0;
	/**
	 * @author user
	 *
	 */
	public static final int R = 2;
	/**
	 * @author user
	 *
	 */
	public static final int F = 1;
	/**
	 * @author user
	 *
	 */
	public static final int L = -1;
	/**
	 * @author user
	 *
	 */
	public static final int N = 3;
	/**
	 * @author user
	 *
	 */
	public static final int M = 4;

	/**
	 * @author user
	 *
	 */
	@Test
	public void testadd() {
		SingleList x = new SingleList();
		x.add(T);
		x.add(F);
		x.add(T);
		x.add(F);
		x.add(F, T);
		Assert.assertEquals(T, x.get(F));
		Assert.assertEquals(T, x.get(0));
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testremove() {
		SingleList x = new SingleList();
		x.add(T);
		x.add(F);
		x.add(T);
		x.add(F, T);
		Assert.assertEquals(T, x.get(F));
		Assert.assertEquals(M, x.size());
		x.remove(F);
		Assert.assertEquals(F, x.get(F));
		Assert.assertEquals(N, x.size());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testset() {
		SingleList x = new SingleList();
		x.add(T);
		x.add(F);
		x.add(T);
		Assert.assertEquals(F, x.get(F));
		Assert.assertEquals(N, x.size());
		x.set(F, T);
		Assert.assertEquals(T, x.get(F));
		Assert.assertEquals(N, x.size());
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testinvalidget() {
		SingleList x = new SingleList();
		Boolean thrown = false;
		x.add(T);
		x.add(F);
		x.add(T);
		try {
			x.get(L);
		} catch (RuntimeErrorException exception) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	/**
	 * @author user
	 *
	 */
	@Test
	public void testsublist() {
		SingleList x = new SingleList();
		SingleList y = new SingleList();
		x.add(M);
		x.add(N);
		x.add(M);
		x.add(F);
		x.add(N);
		x.add(F);
		y = (SingleList) x.sublist(F, N);
		Assert.assertEquals(N, y.size());
		Assert.assertEquals(M, y.get(F));
		Assert.assertEquals(F, y.get(R));
	}
}

