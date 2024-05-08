import java.util.Scanner;

class DoubleLinkedList {
    Node head;

    DoubleLinkedList(Node value) {
        this.head = value;
    }

    void printList() {
        System.out.println("LinkedList: ");
        Node cur = this.head;
        while (cur != null) {
            System.out.printf("%d <-> ", cur.value);
            cur = cur.next;
        }
        System.out.println("null");
    }
}

class Node {
    int value;
    Node previous;
    Node next;

    Node(int v, Node p, Node n) {
        this.value = v;
        this.previous = p;
        this.next = n;
    }
}

public class task1 {

    public static Node duplicateNumbers(Node head) {
        Node current = head;

        while (current != null) {
            if (current.value % 2 == 1) { 
                Node newNode = new Node(current.value, current.previous, current);
                if (current.previous != null) {
                    current.previous.next = newNode;
                }
                current.previous = newNode;
                if (head == current) {
                    head = newNode;
                }
            }
            current = current.next;
        }

        return head;
    }

    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        int i;

        Node head = new Node(1, null, null);
        DoubleLinkedList list = new DoubleLinkedList(head);

        System.out.println("How many elements in the linked list?");
        int length = scanner.nextInt();

        Node[] nodes = new Node[length];
        for (i = 0; i < length; i++) {
            if (i == 0) {
                nodes[i] = head;
            } else {
                nodes[i] = new Node(i + 1, nodes[i - 1], null);
                nodes[i - 1].next = nodes[i];
            }
        }

        list.printList();

        DoubleLinkedList new_list = new DoubleLinkedList(duplicateNumbers(list.head));
        new_list.printList();
    }
}
