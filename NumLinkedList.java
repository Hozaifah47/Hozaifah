import java.util.*;

public class NumLinkedList {
  NumNode start;

  NumLinkedList() {
    start = null;
  }

  int findMax() throws Exception {
    if (start == null) {
      throw new Exception("the list is empty");
    }

    NumNode temp = start;
    int max = start.num;
    while (temp != null) {
      if (temp.next.num > max) {
        max = temp.next.num;
      }
    }
    return max;
  }

  void insertAtBeginning(NumNode node) {
    if (start == null) {
      start = node;
      return;
    }
    node.next = start;
    start = node;
  }

  int findMidIndex() throws Exception {
    if (start == null) {
      throw new Exception("the list is empty");
    }
    NumNode temp = start;
    int count = 0;
    while (temp != null) {
      count += 1;
      temp = temp.next;
    }
    return count / 2;
  }

  int getMiddle() throws Exception {
    if (start == null) {
      throw new Exception("the list is empty");
    }
    NumNode temp = start;
    int count = 0;
    int middle = 0;
    int mid = findMidIndex();
    while (temp != null) {
      if (count == mid) {
        middle = temp.num;
      }
      count += 1;
      temp = temp.next;
    }
    return middle;
  }

  NumLinkedList reverse() throws Exception {
    if (start == null) {
      throw new Exception("The list is empty");
    }
    NumLinkedList reverse = new NumLinkedList();
    NumNode temp = start;
    while (temp != null) {
      reverse.insertAtBeginning(temp);
      temp = temp.next;
    }
    return reverse;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n Enter 0 to terminate the program");

    int ch = sc.nextInt();
  }
}
