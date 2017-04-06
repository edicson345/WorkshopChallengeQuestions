/*
This is probably a graph problem which I'm still learning about so the O(n^2) solution is an attempt at a trivial solution.
I will probably revisit this problem with a better solution after learning more about graph theory.

4/5/2017: Added a depth first search in order to count the number of grouped 1s
*/

public class dotMatrix
{
  static int COL = 4;
  static int ROW = 4;

  public static boolean canBeVisited(int[][] matrix, int row, int col, boolean[][] visited)
  {
    //return true if the element is within the matrix limits has a value of 1 and has not been visited
    return (row >= 0 && col >= 0 && col < COL && row < ROW && matrix[row][col]==1 && !(visited[row][col]));
  }

  public static void DFS(int[][] matrix, int row, int col, boolean[][] visited)
  {
    //arrays that contain the coordinates of the 8 adjacent elements
    //(-1,-1), (-1, 0), (-1, 1), etc
    int[] rowN = {-1,-1,-1,0,0,1,1,1};
    int[] colN = {-1,0,1,-1,1,-1,0,1};

    //mark the element as visited
    visited[row][col] = true;

    //iterate through the 8 neigboring elements
    for(int i = 0; i < 8; i++)
    {
      //if they are within the matrix and have a 1 value and are not visited yet
      if(canBeVisited(matrix, row+rowN[i], col+colN[i], visited))
        DFS(matrix, row + rowN[i], col + colN[i], visited);
        //recursively call the DFS function
    }
  }

  public static int connectionCount(int[][] matrix)
  {
    //create boolean 2d array that will show if an element has been visited
    boolean[][] visited = new boolean[ROW][COL];

    //variable to keep track of all the connected 1s
    int cnt = 0;

    for(int j = 0; j < ROW; j++)
      for(int k = 0; k < COL; k++)
        if(matrix[j][k] == 1 && !visited[j][k])
        {
          //if the current element is 1 and hasn't been visited call DFS and increment
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
