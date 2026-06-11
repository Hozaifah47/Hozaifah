import java.util.Scanner;

public class NumNode {
  int num;
  NumNode next;

  NumNode() {
    num = 0;
    next = null;
  }

  NumNode(int num) {
    this.num = num;
    next = null;
  }

  void accept() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number");
    num = sc.nextInt();
  }
}
