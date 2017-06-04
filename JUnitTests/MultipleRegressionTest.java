import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import bg.tu.sofia.vvps.constants.Constants;
import bg.tu.sofia.vvps.gauss.Gauss;
import bg.tu.sofia.vvps.regression.MultipleRegression;
import junit.framework.TestCase;

/**
 * Unit tests for {@link MultipleRegression}
 * 
 * @author Aleksandar Kovachev
 *
 */
public class MultipleRegressionTest extends TestCase {
	
	private MultipleRegression regression = new MultipleRegression();
	double[][] matrix = Constants.MATRIX;

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInvalidIndexSum() {
		regression.getSum(matrix, 4);
	}

	@Test(expected = NullPointerException.class)
	public void testNullPointerSum() {
		regression.getSum(null, 1);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInvalidIndexPowSum() {
		regression.getPowSum(matrix, 4);
	}

	@Test(expected = NullPointerException.class)
	public void testNullPointerPowSum() {
		regression.getPowSum(null, 1);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testInvalidIndexMultiplicationSum() {
		regression.getMultiplicationSum(matrix, 4, 4);
	}

	@Test(expected = NullPointerException.class)
	public void testNullPointerMultiplicationSum() {
		regression.getMultiplicationSum(null, 4, 4);
	}

	@Test
	public void testWSum() {
		double indSum = regression.getSum(matrix, 0);
		assertEquals(1670, indSum, 0);
	}

	@Test
	public void testXSum() {
		double indSum = regression.getSum(matrix, 1);
		assertEquals(355, indSum, 0);
	}

	@Test
	public void testYSum() {
		double indSum = regression.getSum(matrix, 2);
		assertEquals(149, indSum, 0);
	}

	@Test
	public void testZSum() {
		double indSum = regression.getSum(matrix, 3);
		BigDecimal bd = new BigDecimal(indSum);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		double roundedRes = bd.doubleValue();
		assertEquals(138.1, roundedRes, 0);
	}

	@Test
	public void testWPowSum() {
		double powSum = regression.getPowSum(matrix, 0);
		assertEquals(641720, powSum, 0);
	}

	@Test
	public void testXPowSum() {
		double powSum = regression.getPowSum(matrix, 1);
		assertEquals(46343, powSum, 0);
	}

	@Test
	public void testYPowSum() {
		double powSum = regression.getPowSum(matrix, 2);
		assertEquals(10557, powSum, 0);
	}

	@Test
	public void testZPowSum() {
		double powSum = regression.getPowSum(matrix, 3);
		BigDecimal bd = new BigDecimal(powSum);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		double roundedRes = bd.doubleValue();
		assertEquals(4047.47, roundedRes, 0);
	}

	@Test
	public void testWXMultiplicationSum() {
		double multSum = regression.getMultiplicationSum(matrix, 0, 1);
		assertEquals(114071, multSum, 0);
	}

	@Test
	public void testWYMultiplicationSum() {
		double multSum = regression.getMultiplicationSum(matrix, 0, 2);
		assertEquals(35495, multSum, 0);
	}

	@Test
	public void testWZMultiplicationSum() {
		double multSum = regression.getMultiplicationSum(matrix, 0, 3);
		BigDecimal bd = new BigDecimal(multSum);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		double roundedRes = bd.doubleValue();
		assertEquals(49225.10, roundedRes, 0);
	}

	@Test
	public void testXYMultiplicationSum() {
		double multSum = regression.getMultiplicationSum(matrix, 1, 2);
		assertEquals(20819, multSum, 0);
	}

	@Test
	public void testXZMultiplicationSum() {
		double multSum = regression.getMultiplicationSum(matrix, 1, 3);
		assertEquals(11202, multSum, 0);
	}

	@Test
	public void testYZMultiplicationSum() {
		double multSum = regression.getMultiplicationSum(matrix, 2, 3);
		assertEquals(4179.4, multSum, 0);
	}

}
