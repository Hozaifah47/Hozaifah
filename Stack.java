public class Stack {
  int top;
  int size;
  int arr[];

  Stack(int size) {
    top = -1;
    this.size = size;
    arr = new int[size];
  }

  Stack() {
    top = -1;
    size = 10;
    arr = new int[size];
  }

  void push(int num) throws Exception {
    if (top == size - 1) {
      throw new Exception("Stack overflow");
    }
    arr[++top] = num;
  }

  int pop() throws Exception {
    if (top == -1) {
      throw new Exception("Stack is empty!");
    }
    return arr[top--];
  }
}
