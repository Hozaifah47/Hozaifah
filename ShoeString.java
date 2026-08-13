import java.util.*;

public class ShoeString {
  int StringIntersect(int arr[]) {
    int count = 0, i, j;
    for (j = 0; j < arr.length - 1; j++) {
      for (i = j + 1; i < arr.length; i++) {

        if (arr[j] > arr[i]) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int num, i;
    ShoeString ob = new ShoeString();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a Number!");
    num = sc.nextInt();
    if (num < 0) {
      System.out.println("Invalid");
      return;
    }
    int arr[] = new int[num];
    boolean used[] = new boolean[num];

    for (i = 0; i < num; i++) {
      System.out.println("Enter the 2nd hook to be hooked with hook number " + i);
      arr[i] = sc.nextInt();

      if (arr[i] < 0 || arr[i] >= num || used[arr[i]]) {
        System.out.println("Invalid");
        return;
      }

      used[arr[i]] = true;
    }
    System.out.println("Number of intersections =" + ob.StringIntersect(arr));
  }
}
