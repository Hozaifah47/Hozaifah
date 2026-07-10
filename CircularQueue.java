import java.util.Scanner;

class CircularQueue {

  int front, rear, size;
  int arr[];

  public CircularQueue() {
    front = rear = -1;
    size = 10;
    arr = new int[size];
  }

  public CircularQueue(int size) {
    front = -1;
    rear = -1;
    this.size = size;
    arr = new int[size];
  }

  void enqueue(int num) throws Exception {

    if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
      throw new Exception("the queue is full");
    }
    if (front == -1) {
      front = rear = 0;
    } else if (rear == size - 1) {
      rear = 0;
    } else {
      rear++;
    }

    arr[rear] = num;
  }

  int dequeue() throws Exception {
    if (front == -1) {
      throw new Exception("The queue is empty");
    }
    int temp = front;
    if (front == rear) {
      front = rear = -1;
    } else if (front == size - 1) {
      front = 0;
    } else {
      front++;
    }
    return arr[temp];
  }

  void display() {

    int visual[] = new int[size];

    if (front != -1) {
      int i = front;

      while (true) {
        visual[i] = arr[i];

        if (i == rear) {
          break;
        }
        if (i == size - 1) {
          i = 0;
        } else {
          i++;
        }
      }
    }
    for (int i = 0; i < size; i++) {
      System.out.println("| " + visual[i] + " |");
    }
  }

  public static void main(String[] args) {
    int choice, size, num;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a size of the array");
    System.out.println("Enter 0 for default size(default size =10)");
    size = sc.nextInt();
    if (size < -1) {
      System.out.println("Invalid!");
      return;
    }
    CircularQueue ob;

    if (size == 0) {
      ob = new CircularQueue();
    } else {
      ob = new CircularQueue(size);
    }
    do {
      System.out.println("Enter 0 to terminate the program");
      System.out.println("Enter 1 to enqueue");
      System.out.println("Enter 2 to dequeue");
      System.out.println("Enter 3 to display array");
      choice = sc.nextInt();
      try {

        switch (choice) {
          case 1:
            System.out.println("Enter a number to be enqued (must not be 0)");
            num = sc.nextInt();
            if (num == 0) {
              System.out.println("Invalid!");
              return;
            }
            ob.enqueue(num);
            break;

          case 2:
            System.out.println(ob.dequeue());
            break;

          case 3:
            ob.display();
            break;
        }
      } catch (Exception e) {
        System.out.println("Error :" + e.getMessage());
      }
    } while (choice != 0);
  }
}
