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
