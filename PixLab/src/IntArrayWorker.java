public class IntArrayWorker
{
  // returns the # of times a passed value is detected
  public int getCount(int value)
  {
    int count = 0;
    for (int i = 0; i < matrix.length; i++)
    {
      for (int k = 0; k < matrix[0].length; k++)
      {
        if (matrix[i][k] == value)
          count++;
      }
    }
    return count;
  }

  // returns the largest value
  public int getLargest()
  {
    int largest = -1;
    for (int i = 0; i < matrix.length; i++)
    {
      for (int k = 0; k < matrix[0].length; k++)
      {
        if (matrix[i][k] >= largest)
          largest = matrix[i][k];
      }
    }
    return largest;
  }

  // returns all the values in a [passed column added together
  public int getColTotal(int col)
  {
    int total = 0;
    for (int i = 0; i < matrix[0].length; i++)
    {
      total += matrix[0][i];
    }
    return total;
  }

  /** two dimensional matrix */
  private int[][] matrix = null;

  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }

  /**
   * Method to return the total
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
        total = total + matrix[row][col];
    }
    return total;
  }

  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
        total = total + item;
    }
    return total;
  }

  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }

  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
        System.out.print( matrix[row][col] + " " );
      System.out.println();
    }
    System.out.println();
  }


  /**
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length;
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }

}