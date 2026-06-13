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
      if (temp.num > max) {
        max = temp.num;
      }
      temp = temp.next;
    }
    return max;
  }

  void insertAtEnd(NumNode node) {
    if (start == null) {
      start = node;
      return;
    }

    NumNode temp = start;

    while (temp.next != null) {
      temp = temp.next;
    }

    temp.next = node;
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
      NumNode newNode = new NumNode();
      newNode.num = temp.num;
      reverse.insertAtBeginning(newNode);
      temp = temp.next;
    }
    return reverse;
  }

  void insertAtBeginning(NumNode node) {
    if (start == null) {
      start = node;
      return;
    }
    node.next = start;
    start = node;
  }

  NumLinkedList reverseWIAB() throws Exception {
    if (start == null) {
      throw new Exception("The list is empty");
    }
    NumLinkedList reverse = new NumLinkedList();
    NumNode temp = start;
    while (temp != null) {
      NumNode node = new NumNode();
      node.num = temp.num;
      node.next = reverse.start;
      reverse.start = node;
      temp = temp.next;
    }

    return reverse;
  }

  void display() throws Exception {
    if (start == null) {
      throw new Exception("the list is empty");
    }
    NumNode temp = start;

    while (temp != null) {
      System.out.println(temp.num);
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    NumLinkedList list = new NumLinkedList();
    int ch;

    try {
      do {
        System.out.println("\nEnter 0 to terminate the program");
        System.out.println("Enter 1 to add a node");
        System.out.println("Enter 2 to display list");
        System.out.println("Enter 3 to reverse list");
        System.out.println("Enter 4 to find mid index");
        System.out.println("Enter 5 to find mid node");
        System.out.println("Enter 6 tofind max");
        ch = sc.nextInt();
        switch (ch) {
          case 0:
            break;
          case 1:
            NumNode b2 = new NumNode();
            b2.accept();
            list.insertAtEnd(b2);
            System.out.println("Number Added");
            break;
          case 2:
            System.out.println("The list");
            list.display();
            break;
          case 3:
            list = list.reverseWIAB();
            System.out.println("List Reversed");
            break;
          case 4:
            System.out.println("The mid index is " + list.findMidIndex());
            break;
          case 5:
            System.out.println("The middle node is " + list.getMiddle());
            break;
          case 6:
            System.out.println("The max node is " + list.findMax());
            break;

          default:
            System.out.println("Invalid input!");
        }
      } while (ch != 0);
    } catch (Exception e) {
      System.out.println("error :" + e.getMessage());
    }
  }
}
