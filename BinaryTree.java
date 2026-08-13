import java.util.*;

public class BinaryTree {
  BinaryNode Start;

  void preorder(BinaryNode root) { // rt l r
    if (root == null) {
      return;
    }
    System.out.print(root.num + "  ");
    preorder(root.left);
    preorder(root.right);
  }

  void inorder(BinaryNode root) { // l rt r
    if (root == null) {
      return;
    }
    inorder(root.left);
    System.out.print(root.num + "  ");
    inorder(root.right);
  }

  void postorder(BinaryNode root) { // l r rt
    if (root == null) {
      return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.num + "  ");
  }

  public static void main(String[] args) {
    BinaryTree ob = new BinaryTree();
    BinaryNode A = new BinaryNode(1);
    BinaryNode B = new BinaryNode(2);
    BinaryNode C = new BinaryNode(3);
    BinaryNode D = new BinaryNode(4);
    BinaryNode E = new BinaryNode(5);
    BinaryNode F = new BinaryNode(6);
    BinaryNode G = new BinaryNode(7);
    BinaryNode H = new BinaryNode(8);
    BinaryNode I = new BinaryNode(9);

    A.left = B;
    B.left = E;
    B.right = C;
    C.left = I;

    A.right = D;
    D.right = F;
    F.left = G;
    F.right = H;
    System.out.println("pre");
    ob.preorder(A);
    System.out.println();
    System.out.println("in");
    ob.inorder(A);
    System.out.println();
    System.out.println("post");
    ob.postorder(A);
    System.out.println();
    Scanner sc = new Scanner(System.in);
    System.out.println("to Display enter the Alphabet of the node");
    char ch = Character.toUpperCase(sc.nextLine().charAt(0));
    switch (ch) {
      case 'A':
        BinaryNode.display(A, 0);
        break;
      case 'B':
        BinaryNode.display(B, 0);
        break;
      case 'C':
        BinaryNode.display(C, 0);
        break;
      case 'D':
        BinaryNode.display(D, 0);
        break;
      case 'E':
        BinaryNode.display(E, 0);
        break;
      case 'F':
        BinaryNode.display(F, 0);
        break;
      case 'G':
        BinaryNode.display(G, 0);
        break;
      case 'H':
        BinaryNode.display(H, 0);
        break;
      case 'I':
        BinaryNode.display(I, 0);
        break;

      default:
        System.out.println("invalid");
    }
  }
}
