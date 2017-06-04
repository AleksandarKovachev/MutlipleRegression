import org.junit.Assert;
import org.junit.Test;

import bg.tu.sofia.vvps.gauss.Gauss;
import junit.framework.TestCase;

/**
 * Unit tests for {@link Gauss}
 * 
 * @author Aleksandar Kovachev
 *
 */
public class GaussTest extends TestCase {
	
	Gauss gauss = new Gauss();
	double[][] equation = Main.equation;

	@Test
	public void testGaussAlgorithm() {
		double[] expectedResult = { 0.5665, 0.0653, 0.0087, 0.151 };
		double[] givenResult = gauss.gaussAlgorithm(equation);
		Assert.assertArrayEquals(expectedResult, givenResult, 0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullPointerGaussAlgorithm() {
		gauss.gaussAlgorithm(null);
	}

	@Test
	public void testRoundResult() {
		double[] expectedResult = { 6.7013, 0.0784, 0.015, 0.2461 };
		double[] equation = { 6.7013121212, 0.07842141, 0.0150012, 0.24610210 };
		double[] givenResult = gauss.roundResult(equation);
		Assert.assertArrayEquals(expectedResult, givenResult, 0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullPointerRoundResult() {
		gauss.roundResult(null);
	}

	@Test
	public void testSwapCurrentAndMaxRow() {
		gauss.swapCurrentAndMaxRow(equation, equation.length, 2, 1);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInvalidIndexSwapCurrentAndMaxRow() {
		gauss.swapCurrentAndMaxRow(equation, equation.length, 4, 0);
	}

	@Test(expected = NullPointerException.class)
	public void testNullPointerSwapCurrentAndMaxRow() {
		gauss.swapCurrentAndMaxRow(null, equation.length, 2, 0);
	}

	@Test
	public void testSetLowerRowsZero() {
		gauss.setLowerRowsZero(equation, equation.length, 0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInvalidIndexSetLowerRowsZero() {
		gauss.setLowerRowsZero(equation, equation.length, 6);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testNullPointerSetLowerRowsZero() {
		gauss.setLowerRowsZero(null, equation.length, 6);
	}
	
	@Test
	public void testMaxIndex() {
		int maxRow = gauss.getMaxIndex(equation, equation.length, 0);
		assertEquals(0, maxRow);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInvalidIndexMaxIndex() {
		gauss.getMaxIndex(equation, equation.length, 4);
	}

	@Test(expected = NullPointerException.class)
	public void testNullPointerMaxIndex() {
		gauss.getMaxIndex(null, equation.length, 2);
	}

}
