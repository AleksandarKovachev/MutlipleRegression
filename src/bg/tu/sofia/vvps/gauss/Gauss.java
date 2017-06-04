package bg.tu.sofia.vvps.gauss;

import java.math.BigDecimal;
import java.math.RoundingMode;

import bg.tu.sofia.vvps.constants.Messages;

/**
 * Logic for calculating matrix in Gauss algorithm
 * 
 * @author Aleksandar Kovachev
 *
 */
public class Gauss {

	public double[] gaussAlgorithm(double[][] equation) {
		int eqLength = 0;
		double[] result = null;

		try {
			eqLength = equation.length;
			result = new double[eqLength];

			// Main loop for processing the equation
			for (int index = 0; index < eqLength; index++) {
				int max = getMaxIndex(equation, eqLength, index);
				swapCurrentAndMaxRow(equation, eqLength, max, index);
				setLowerRowsZero(equation, eqLength, index);
			}

			// Recording results in the array
			for (int i = eqLength - 1; i >= 0; i--) {
				result[i] = equation[i][eqLength] / equation[i][i];
				for (int counter = i - 1; counter >= 0; counter--) {
					equation[counter][eqLength] -= equation[counter][i] * result[i];
				}
			}
		} catch (NullPointerException n) {
			String errorMessage = String.format(Messages.NULL_MESSAGE, n);
			System.err.println(errorMessage);
		}

		return roundResult(result);
	}

	// Method which returns maximal row's index in the equation
	public int getMaxIndex(double[][] equation, int eqLength, int index) {
		int maxRow = 0;
		try {
			double maxEl = equation[index][index];
			maxRow = index;

			for (int k = index + 1; k < eqLength; k++) {
				if (equation[k][index] > maxEl) {
					maxEl = equation[k][index];
					maxRow = k;
				}
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			String errorMessage = String.format(Messages.ERROR_MESSAGE, "finding maximal row's index", e);
			System.err.println(errorMessage);
		}

		return maxRow;
	}

	// Method which swaps current row with maximal row
	public void swapCurrentAndMaxRow(double[][] equation, int egLength, int maxRow, int index) {
		try {
			for (int k = index; k < egLength + 1; k++) {
				double tmp = equation[maxRow][k];
				equation[maxRow][k] = equation[index][k];
				equation[index][k] = tmp;
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			String errorMessage = String.format(Messages.ERROR_MESSAGE, "swapping curent row with maximal row", e);
			System.err.println(errorMessage);
		}
	}

	// Method which sets lower rows to zeros
	public void setLowerRowsZero(double[][] equation, int eqLength, int index) {
		try {
			for (int row = index + 1; row < eqLength; row++) {
				double division = -equation[row][index] / equation[index][index];
				for (int col = index; col < eqLength + 1; col++) {
					if (index == col) {
						equation[row][col] = 0;
					} else {
						equation[row][col] += division * equation[index][col];
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			String errorMessage = String.format(Messages.ERROR_MESSAGE, "setting lower rows to zero in the equation",
					e);
			System.err.println(errorMessage);
		}
	}

	// Method which rounds the result to 4 decimal places
	public double[] roundResult(double[] res) {
		double[] roundedRes = null;

		try {
			roundedRes = new double[res.length];

			for (int index = 0; index < res.length; index++) {
				BigDecimal bd = new BigDecimal(res[index]);
				bd = bd.setScale(4, RoundingMode.HALF_UP);
				roundedRes[index] = bd.doubleValue();
			}
		} catch (NullPointerException n) {
			String errorMessage = String.format(Messages.NULL_MESSAGE, n);
			System.err.println(errorMessage);
		}

		return roundedRes;
	}
}
