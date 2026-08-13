class BinaryNode {
  BinaryNode left;
  BinaryNode right;
  int num;

  public BinaryNode() {
    num = 0;
    left = null;
    right = null;
  }

  public BinaryNode(int num) {
    left = null;
    right = null;
    this.num = num;
  }

  static void display(BinaryNode start, int depth) {
    if (start == null) {
      return;
    }

    display(start.right, depth + 1);

    for (int i = 0; i < depth; i++) {
      System.out.print("   ");
    }

    System.out.println(start.num);

    display(start.left, depth + 1);
  }
}
