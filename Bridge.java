import java.util.*;

public class Bridge {

  String[] slowPairFirst(int arr[], String names[]) {
    String steps[] = new String[2 * arr.length];
    int n = arr.length, i, j, temp, total, last, k;
    String tname;

    for (i = 0; i < n - 1; i++) {
      for (j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          tname = names[j];
          arr[j] = arr[j + 1];
          names[j] = names[j + 1];
          arr[j + 1] = temp;
          names[j + 1] = tname;
        }
      }
    }

    k = 0;
    total = 0;
    last = arr.length - 1;

    while (last > 2) {

      total += arr[1];
      steps[k++] = names[0] + " and " + names[1] + " -> (+" + arr[1] + " = " + total + " min)";

      total += arr[0];
      steps[k++] = names[0] + " <- (+" + arr[0] + " = " + total + " min)";

      total += arr[last];
      steps[k++] =
          names[last - 1] + " and " + names[last] + " -> (+" + arr[last] + " = " + total + " min)";

      total += arr[1];
      steps[k++] = names[1] + " <- (+" + arr[1] + " = " + total + " min)";

      last -= 2;
    }

    if (last == 2) {

      total += arr[1];
      steps[k++] = names[0] + " and " + names[1] + " -> (+" + arr[1] + " = " + total + " min)";

      total += arr[0];
      steps[k++] = names[0] + " <- (+" + arr[0] + " = " + total + " min)";

      total += arr[2];
      steps[k++] = names[0] + " and " + names[2] + " -> (+" + arr[2] + " = " + total + " min)";
    } else if (last == 1) {

      total += arr[1];
      steps[k++] = names[0] + " and " + names[1] + " -> (+" + arr[1] + " = " + total + " min)";
    } else if (last == 0) {

      total += arr[0];
      steps[k++] = names[0] + " -> (+" + arr[0] + " = " + total + " min)";
    }

    steps[k] = "Total Time = " + total + " min";

    return steps;
  }

  public static void main(String args[]) {

    int i, size;
    String steps[];
    Bridge ob = new Bridge();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of people");
    size = sc.nextInt();
    if (size < 1) {
      System.out.println("Invalid Input!");
      return;
    }
    int time[] = new int[size];
    String name[] = new String[size];
    for (i = 0; i < size; i++) {
      System.out.println("Enter a name");
      name[i] = sc.next();
      System.out.println("Enter the time taken to cross the bridge in minutes");
      time[i] = sc.nextInt();
      if (time[i] < 0) {
        System.out.println("Invalid Input!");
        return;
      }
    }
    steps = ob.slowPairFirst(time, name);
    i = 0;
    do {
      System.out.println(steps[i]);
      i++;

    } while (steps[i] != null);
  }
}
