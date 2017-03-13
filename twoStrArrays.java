/*
Here I attempted to create two solutions. The first was to create a HashSet of the Strings in the first array. The HashSet could 
probably be made from either array as the solution has to be a subset of the arrays. The idea behind using a Set was to produce a unique
set of Strings that are common between the two array. The running time of the first solution would be O(n). The second solution was made 
with the restriction that less memory needed to be used. The idea was to sort the two arrays which immediately put the running time at 
O(nlogn). With the arrays sorted a String from array1 could be used in a binary search to locate a matching String in array2 and then 
could be added to the array of common Strings to be returned. Ideally the second solution would work best under the condition that there
are no duplicate strings and the arrays are already sorted.
*/

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
