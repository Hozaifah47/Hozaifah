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

            if (stack2.top == -1) { // still empty
                throw new Exception("Queue is empty!");
            }

            return stack2.pop();

        } catch (Exception e) {
            throw new Exception("Queue underflow");
        }

    }
}