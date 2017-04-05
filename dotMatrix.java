

public class dotMatrix
{
  static int COL = 4;
  static int ROW = 4;

  public static boolean canBeVisited(int[][] matrix, int row, int col, boolean[][] visited)
  {
    return (row >= 0 && col >= 0 && col < COL && row < ROW && matrix[row][col]==1 && !(visited[row][col]));
  }

  public static void DFS(int[][] matrix, int row, int col, boolean[][] visited)
  {
    int[] rowN = {-1,-1,-1,0,0,1,1,1};
    int[] colN = {-1,0,1,-1,1,-1,0,1};

    visited[row][col] = true;

    for(int i = 0; i < 8; i++)
    {
      if(canBeVisited(matrix, row+rowN[i], col+colN[i], visited))
        DFS(matrix, row + rowN[i], col + colN[i], visited);
    }
  }

  public static int connectionCount(int[][] matrix)
  {
    boolean[][] visited = new boolean[ROW][COL];

    int cnt = 0;

    for(int j = 0; j < ROW; j++)
      for(int k = 0; k < COL; k++)
        if(matrix[j][k] == 1 && !visited[j][k])
        {
          DFS(matrix, j, k, visited);
          cnt++;
        }

    return cnt;
  }

  public static void start()
  {
    int[][] matrix = {{0,1,1,0},
                         {0,0,0,0},
                         {1,0,0,1},
                         {0,0,0,1}};

    for(int i = 0; i < matrix.length; i++)
      for(int j = 0; j < matrix[i].length; j++)
      {
        if(matrix[i][j] == 1)
        {
          System.out.println(i + "," + j);
        }
      }
  }

  public static void main(String[] args)
  {
    int[][] matrix = {{0,1,1,0},
                      {0,0,0,0},
                      {1,0,0,1},
                      {0,0,0,1}};

    dotMatrix dot = new dotMatrix();
    System.out.println("Number of connected dots: " + connectionCount(matrix));
    System.out.println("At coordinates: ");

    start();
  }
}
