class Node {
    double value;
    Node next;

    Node(double value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class LinkedList {
    Node root;
    Node last;

    LinkedList(Node root) {
        this.root = root;
        this.last = root;
    }

    public void addElement(Node value) {
        if (root == null) {
            root = value;
            last = value;
        } else {
            last.next = value;
            last = value;
        }
    }

    public void printList() {
        Node current = root;
        System.out.println("Linked List");
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Queue {
    LinkedList data;

    Queue(double value) {
        Node newNode = new Node(value, null);
        data = new LinkedList(newNode);
    }

    public void enqueue(double value) {
        Node newNode = new Node(value, null);
        data.addElement(newNode);
        data.last = newNode;
    }

    public double dequeue() {
        if (data.root == null) {
            throw new IllegalStateException("Queue is empty");
        }
        Node cur_node = data.root;
        data.root = cur_node.next;
        return cur_node.value;
    }

    public void printQueue() {
        data.printList();
    }
}

public class task1 {
    public static void main(String[] argv) {
        Queue new_queue = new Queue(2.2);
        new_queue.enqueue(2.3);
        new_queue.enqueue(2.2);
        new_queue.enqueue(5.1);
        new_queue.enqueue(6.7);
        new_queue.printQueue();

        for (int i = 0; i < 3; i++) {
            double dequeuedValue = new_queue.dequeue();
            System.out.println("Deleted element: " + dequeuedValue);
        }
        new_queue.enqueue(1.9);
        new_queue.printQueue();
    }
}
