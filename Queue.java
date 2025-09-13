import java.util.*;

class Queue {

    int f;
    int r;
    int size;
    int arr[];

    Queue() {
        f = -1;
        r = -1;
        size = 10;
        arr = new int[size];
    }

    Queue(int size) {
        f = -1;
        r = -1;
        this.size = size;
        arr = new int[size];
    }

    void enqueue(int num) throws Exception {
        if (r == size - 1) {
            throw new Exception("Queue overflow");
        }
        if (r == -1) {
            f = 0;
        }
        arr[++r] = num;
    }

    int dequeue() throws Exception {
        if (f == -1) {
            throw new Exception("Queue is empty");
        }
        int n = arr[f++];
        if (f > r) {
            f = r = -1;
        }
        return n;
    }
}
