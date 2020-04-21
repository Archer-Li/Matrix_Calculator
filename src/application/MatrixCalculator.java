package application;

/**
 * This class defines required methods to do calculation on Matrixs
 * 
 * @author Jesse, Houming Chen
 *
 */
public class MatrixCalculator {
  
  public enum Mode {
    FRACTION, // Gives the result in fraction
    DECIMAL // Gives the result in decimal
  }
  
  public Mode mode;
  public String[][] matrix1, matrix2;
  
  public MatrixCalculator(String[][] matrix1, String[][] matrix2) {
    this.matrix1 = matrix1;
    this.matrix2 = matrix2;
  }
  
  private String[][] properFormatted(Matrix matrix) {
    if(mode == Mode.DECIMAL)
      return matrix.toDecimalStringMatrix();
    else 
      return matrix.toStringMatrix();
  }
  
  public String[][] add() throws MatrixDimensionsMismatchException{
    Matrix firstMatrix = new Matrix(matrix1);
    Matrix secondMatrix = new Matrix(matrix2);
    Matrix answeMatrix = firstMatrix.add(secondMatrix);
    return properFormatted(answeMatrix);
  }
  
  public String[][] subtract() throws MatrixDimensionsMismatchException{
    Matrix firstMatrix = new Matrix(matrix1);
    Matrix secondMatrix = new Matrix(matrix2);
    Matrix answeMatrix = firstMatrix.subtract(secondMatrix);
    return properFormatted(answeMatrix);
  }
  
  public String[][] multiply() throws MatrixDimensionsMismatchException{
    Matrix firstMatrix = new Matrix(matrix1);
    Matrix secondMatrix = new Matrix(matrix2);
    Matrix answeMatrix = firstMatrix.multiply(secondMatrix);
    return properFormatted(answeMatrix);
  }
  
  public String getDeterminant() throws MatrixDimensionsMismatchException{
    Matrix firstMatrix = new Matrix(matrix1);
    return firstMatrix.determinant().toString();
  }
  
  public String[][] getInverse() throws MatrixDimensionsMismatchException{
    Matrix firstMatrix = new Matrix(matrix1);
    return properFormatted(firstMatrix.inverse());
  }
  
  /**
   * Demo
   * @param args
   * @throws MatrixDimensionsMismatchException 
   */
  public static void main(String[] args) throws MatrixDimensionsMismatchException {
    
    String[][] matrixA = {{"1", "0", "0.1"}, 
                          {"5/3", "0", "-1/3"},
                          {"-3", "0.4", "-0.333"}};
    String[][] matrixB = {{"1", "2", "-3"}, 
                          {"1/3", "1/2", "-1/1024"},
                          {"0.5", "0.2", "-0.3"},};
    
    MatrixCalculator matrixCalculator = new MatrixCalculator(matrixA, matrixB);
    
    System.out.println("matirxC = matirxA + matrixB");
    String[][] matrixC = matrixCalculator.add();
    
    System.out.println("Print matirx C");
    for(String[] row : matrixC) {
      for(String number : row)
        System.out.print(number + ' ');
      System.out.print("\n");
    }
    System.out.print("\n");
    
    System.out.println("matirxD = inverse of matrixA");
    String[][] matrixD = matrixCalculator.getInverse();
    
    System.out.println("Print matirx D");
    for(String[] row : matrixD) {
      for(String number : row)
        System.out.print(number + ' ');
      System.out.print("\n");
    }
    System.out.print("\n");
    
    System.out.println("matirxE = inverse of matrixA (in decimal)");
    matrixCalculator.mode = Mode.DECIMAL;
    String[][] matrixE = matrixCalculator.getInverse();
    
    System.out.println("Print matirx E");
    for(String[] row : matrixE) {
      for(String number : row)
        System.out.print(number + ' ');
      System.out.print("\n");
    }
  }
  
}
