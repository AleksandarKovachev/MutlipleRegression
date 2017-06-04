import bg.tu.sofia.vvps.constants.Constants;
import bg.tu.sofia.vvps.gauss.Gauss;
import bg.tu.sofia.vvps.regression.MultipleRegression;

/**
 * Main class for run the application.
 * 
 * @author Aleksandar Kovachev
 *
 */
public class Main {
	
private static Gauss gauss = new Gauss();
	
	private static MultipleRegression regression = new MultipleRegression();

	protected static double matrix[][] = Constants.MATRIX;
	
	static int matrixLength = matrix.length;
	
	protected static double[][] equation = {
		{ matrixLength, 
			regression.getSum(matrix, 0), 
			regression.getSum(matrix, 1),
			regression.getSum(matrix, 2), 
			regression.getSum(matrix, 3) },
		
		{ regression.getSum(matrix, 0), 
			regression.getPowSum(matrix, 0),
			regression.getMultiplicationSum(matrix, 0, 1), 
			regression.getMultiplicationSum(matrix, 0, 2),
			regression.getMultiplicationSum(matrix, 0, 3) },
		
		{ regression.getSum(matrix, 1), 
			regression.getMultiplicationSum(matrix, 0, 1),
			regression.getPowSum(matrix, 1), 
			regression.getMultiplicationSum(matrix, 1, 2),
			regression.getMultiplicationSum(matrix, 1, 3) },

		{ regression.getSum(matrix, 2),
			regression.getMultiplicationSum(matrix, 0, 2),
			regression.getMultiplicationSum(matrix, 1, 2), 
			regression.getPowSum(matrix, 2),
			regression.getMultiplicationSum(matrix, 2, 3) } 
	};
	
	public static void main(String[] args) {
		double[] result = new double[equation.length];
		result = gauss.gaussAlgorithm(equation);
		

		for (int index = 0; index < equation.length; index++) {
			System.out.print("B" + index + " = " + result[index] + " ");
		}
	}

}
