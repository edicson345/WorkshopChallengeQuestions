/*
This is probably a graph problem which I'm still learning about so the O(n^2) solution is an attempt at a trivial solution. 
I will probably revisit this problem with a better solution after learning more about graph theory.
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
