
import java.util.Arrays;
import java.util.*;

public class twoStrArrays
{

  public static String[] solution1()
  {
    String[] arr1 = {"foo", "bar", "edicson", "fiu", "organizer", "address", "foo", "bar"};
    String[] arr2 = {"address", "organizer", "bar", "accordian", "atom", "IDE"};

    HashSet<String> set = new HashSet<String>();
    for(int i = 0; i < arr1.length; i++)
    {
      set.add(arr1[i]);
    }

    String[] holder = new String[set.size()];

    for(int i = 0; i < arr2.length; i++)
    {
      if(set.contains(arr2[i]))
        holder[i] = arr2[i];
    }

    return holder;
  }

  public static String[] solution2()
  {
    String[] arr1 = {"foo", "bar", "edicson", "fiu", "organizer", "address"};
    String[] arr2 = {"address", "organizer", "bar", "accordian", "atom", "IDE"};

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    String[] holder = new String[Math.max(arr1.length, arr2.length)];

    for(int i = 0; i < arr1.length; i++)
    {
        if(bSearch(arr2, arr1[i]))
          holder[i] = arr1[i];
    }

    return holder;
  }

  public static boolean bSearch(String[] arr, String s)
  {
    int l = 0, r = arr.length - 1;

    while(l <= r)
    {
      int mid = (l + r)/2;

      if(arr[mid].equals(s))
        return true;

      if(arr[mid].compareTo(s) < 0)
        l = mid + 1;
      else if(arr[mid].compareTo(s) > 0)
        r = mid - 1;
    }

    return false;
  }

  public static void main(String[] args)
  {
    String[] result = solution1();

    for(int i = 0; i < result.length; i++)
    {
      if(result[i] == null)
        continue;
      else
        System.out.println(result[i]);
    }

    System.out.println(" ");

    result = solution2();
    for(int i = 0; i < result.length; i++)
    {
      if(result[i] == null)
        continue;
      else
        System.out.println(result[i]);
    }

  }

}
