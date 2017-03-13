/*
This is probably a graph problem which I'm still learning about so the O(n^2) solution I made is a pretty mediocre attempt to produce 
some kind of result. The brute force way this was done was to visit the entire 4x4 matrix searching for '1's and printing out the row 
and column. I will probably revisit this problem with a better solution after learning more about graph theory.
*/

public class dotMatrix
{

  public static void start()
  {
    int[][] adjMatrix = {{0,1,1,0},
                         {1,0,0,0},
                         {1,0,0,0},
                         {0,0,0,0}};

    for(int i = 0; i < adjMatrix.length; i++)
      for(int j = 0; j < adjMatrix[i].length; j++)
      {
        if(adjMatrix[i][j] == 1)
        {
          System.out.println(i + "," + j);
        }
      }
  }

  public static void main(String[] args)
  {
    start();
  }
}
