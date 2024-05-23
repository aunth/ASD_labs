class Node {
    long data;
    Node right;
    Node down;

    Node(long data) {
        this.data = data;
        this.right = null;
        this.down = null;
    }
}

class LinkedListMatrix {
    Node head;
    int rows;
    int cols;

    LinkedListMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.head = generateMatrix(rows, cols);
    }

    private Node generateMatrix(int rows, int cols) {
        Node headNode = new Node((long)(Math.random() * 10 + 1));
        Node currentRowHead = headNode;

        Node currentNode = headNode;
        for (int j = 1; j < cols; j++) {
            currentNode.right = new Node((long)(Math.random() * 10 + 1));
            currentNode = currentNode.right;
        }

        for (int i = 1; i < rows; i++) {
            currentRowHead.down = new Node((long)(Math.random() * 10 + 1));
            currentRowHead = currentRowHead.down;
            currentNode = currentRowHead;
            Node aboveNode = headNode;

            for (int k = 0; k < i - 1; k++) {
                aboveNode = aboveNode.down;
            }

            for (int j = 1; j < cols; j++) {
                currentNode.right = new Node((long)(Math.random() * 10 + 1));
                aboveNode = aboveNode.right;
                aboveNode.down = currentNode.right;
                currentNode = currentNode.right;
            }
        }

        return headNode;
    }

    public Result calculateMatrix() {
        long sumAboveDiagonal = 0;
        long productBelowDiagonal = 1;

        Node rowHead = head;
        for (int i = 0; i < rows; i++) {
            Node currentNode = rowHead;
            for (int j = 0; j < cols; j++) {
                if (j > i) {
                    sumAboveDiagonal += currentNode.data;
                } else if (j < i) {
                    productBelowDiagonal *= currentNode.data;
                }
                currentNode = currentNode.right;
            }
            rowHead = rowHead.down;
        }

        return new Result(sumAboveDiagonal, productBelowDiagonal);
    }

    public void printMatrix() {
        Node rowHead = head;
        while (rowHead != null) {
            Node currentNode = rowHead;
            while (currentNode != null) {
                System.out.print(currentNode.data + "\t");
                currentNode = currentNode.right;
            }
            System.out.println();
            rowHead = rowHead.down;
        }
    }

    static class Result {
        long sumAboveDiagonal;
        long productBelowDiagonal;

        Result(long sumAboveDiagonal, long productBelowDiagonal) {
            this.sumAboveDiagonal = sumAboveDiagonal;
            this.productBelowDiagonal = productBelowDiagonal;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedListMatrix matrixA = new LinkedListMatrix(6, 6);
        LinkedListMatrix matrixB = new LinkedListMatrix(4, 4);

        LinkedListMatrix.Result resultA = matrixA.calculateMatrix();
        System.out.println("Матриця A:");
        matrixA.printMatrix();
        System.out.println("Сума елементів над головною діагоналлю в A: " + resultA.sumAboveDiagonal);
        System.out.println("Добуток елементів під головною діагоналлю в A: " + resultA.productBelowDiagonal);

        LinkedListMatrix.Result resultB = matrixB.calculateMatrix();
        System.out.println("\nМатриця B:");
        matrixB.printMatrix();
        System.out.println("Сума елементів над головною діагоналлю в B: " + resultB.sumAboveDiagonal);
        System.out.println("Добуток елементів під головною діагоналлю в B: " + resultB.productBelowDiagonal);
    }
}
