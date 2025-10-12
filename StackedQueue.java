import java.util.*;

public class StackedQueue {
    Stack stack1;
    Stack stack2;

    StackedQueue(int size) {
        stack1 = new Stack(size);
        stack2 = new Stack(size);
    }

    public void enqueue(int x) throws Exception {
        try {
            stack1.push(x);
        } catch (Exception e) {
            throw new Exception("Queue overflow");
        }
    }

    public int dequeue() throws Exception {
        try {
            if (stack2.top == -1) {
                while (stack1.top != -1) {
                    stack2.push(stack1.pop());
                }
            }

            if (stack2.top == -1) {
                throw new Exception("Queue is empty!");
            }

            return stack2.pop();

        } catch (Exception e) {
            throw new Exception("Queue underflow");
        }

    }

    public static void main(String[] args) {
        int size, choice, num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        size = sc.nextInt();
        StackedQueue ob = new StackedQueue(size);

        do {
            System.out.println("Enter 0 to terminate the program 1 for Enqueue 2 for Dequque");
            choice = sc.nextInt();
            if (choice > 2 || choice < 0) {
                System.out.println("Invalid Input!");
                return;
            }
            try {
                if (choice == 1) {
                    System.out.println("Enter a number to Enqueue");
                    num = sc.nextInt();
                    ob.enqueue(num);
                }
                if (choice == 2) {
                    System.out.println("Deququed: " + ob.dequeue());

                }
            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                return;
            }

        } while (choice != 0);

    }
}