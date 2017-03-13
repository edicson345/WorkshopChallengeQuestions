public class dotMatrix
{

  public static void start()
  {
    int[][] adjMatrix = {{0,1,1,0},
                         {1,0,0,0},
                         {1,0,0,0},
                         {0,0,0,0}};

    boolean[][] hasNeighbor = new boolean[adjMatrix.length][adjMatrix[0].length];

    for(int i = 0; i < adjMatrix.length; i++)
      for(int j = 0; j < adjMatrix[i].length; j++)
      {
        if(adjMatrix[i][j] == 1)
        {
          hasNeighbor[i][j] = true;
        }
      }

    for(int i = 0; i < hasNeighbor.length; i++)
        for(int j = 0; j < hasNeighbor[i].length; j++)
        {
          if(hasNeighbor[i][j])
            System.out.println(i + "," + j);
        }
  }

  public static void main(String[] args)
  {
    start();
  }
}
