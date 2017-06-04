package bg.tu.sofia.vvps.regression;

import bg.tu.sofia.vvps.constants.Messages;

/**
 * Functionality for calculating multiple regression.
 * 
 * @author Aleksandar Kovachev
 *
 */
public class MultipleRegression {

	// Calculates and returns sum for w, x, y or z depending on given column
	public double getSum(double[][] matrix, int column) {
		float sum = 0;

		try {
			for (int row = 0; row < matrix.length; row++) {
				sum += matrix[row][column];
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			String errorMessage = String.format(Messages.ERROR_MESSAGE, "summing in multiple regression", e);
			System.err.println(errorMessage);
		}

		return sum;
	}

	// Calculates and returns powed sum for w, x, y or z depending on given
	// column
	public double getPowSum(double[][] matrix, int column) {
		double powSum = 0;
		try {
			for (int row = 0; row < matrix.length; row++) {
				powSum += (matrix[row][column] * matrix[row][column]);
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			String errorMessage = String.format(Messages.ERROR_MESSAGE, "summing with pow in multiple regression", e);
			System.err.println(errorMessage);
		}

		return powSum;
	}

	// Calculates and returns sum of multiplied w, x, y or z depending on given
	// columns
	public double getMultiplicationSum(double[][] matrix, int firstColumn, int secondColumn) {
		double sum = 0;
		try {
			for (int row = 0; row < matrix.length; row++) {
				sum += (matrix[row][firstColumn] * matrix[row][secondColumn]);
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			String errorMessage = String.format(Messages.ERROR_MESSAGE, "multiplied summing in multiple regression", e);
			System.err.println(errorMessage);
		}

		return sum;
	}

}
