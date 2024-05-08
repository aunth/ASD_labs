class Node {
    int value;
    Node left;
    Node right;

    Node(int v) {
        this.value = v;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    public void insert(int number) {
        this.root = insertRecursively(this.root, number);
    }

    private Node insertRecursively(Node currentNode, int number) {
        if (currentNode == null) {
            return new Node(number);
        }

        if (number <= currentNode.value) {
            currentNode.left = insertRecursively(currentNode.left, number);
        } else {
            currentNode.right = insertRecursively(currentNode.right, number);
        }
        return currentNode;
    }

    public boolean search(int number) {
        return searchRecursively(this.root, number);
    }

    private boolean searchRecursively(Node currentNode, int number) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.value == number) {
            return true;
        } else if (number < currentNode.value) {
            return searchRecursively(currentNode.left, number);
        } else {
            return searchRecursively(currentNode.right, number);
        }
    }

    public void printTree() {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", root);
        System.out.println(sb.toString());
    }

    private void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            String paddingForBoth = padding + "│  ";
            String pointerForRight = "├──";
            String pointerForLeft = (node.right != null) ? "└──" : "├──";
    
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
    
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.value);
            sb.append("\n");
    
            StringBuilder paddingBuilder = new StringBuilder(padding + "│  ");
    
            String paddingForLeft = paddingBuilder.toString();
            String pointerForLeftSubtree = (node.left != null) ? "├──" : "└──";
    
            traversePreOrder(sb, paddingForLeft, pointerForLeftSubtree, node.left);
        }
    }
    
    private Node deleteRecursively(Node currentNode, int number) {
        if (currentNode == null) {
            return null;
        }

        if (number < currentNode.value) {
            currentNode.left = deleteRecursively(currentNode.left, number);
        } else if (number > currentNode.value) {
            currentNode.right = deleteRecursively(currentNode.right, number);
        } else {

            if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            }

            currentNode.value = minValue(currentNode.right);

            currentNode.right = deleteRecursively(currentNode.right, currentNode.value);
        }
        return currentNode;
    }

    private int minValue(Node node) {
        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    public static void printInorder(Node node)
    {
        if (node == null)
            return;
 
        printInorder(node.left);
 
        System.out.print(node.value + " ");
 
        printInorder(node.right);
    }

    public static void printPostorder(Node node) {
        if (node == null)
            return;
 
        printPostorder(node.right);
 
        System.out.print(node.value + " ");
 
        printPostorder(node.left);

    }

    public void delete(int number) {
        this.root = deleteRecursively(this.root, number);
    }

	public double calculateAverage(Node node) {
		if (node == null) {
			return 0;
		}
	
		int[] result = calculateSumAndCount(node);
	
		return (double) result[0] / result[1];
	}
	
	private int[] calculateSumAndCount(Node node) {
		if (node == null) {
			return new int[]{0, 0};
		}
	
		int[] leftResult = calculateSumAndCount(node.left);
	
		int[] rightResult = calculateSumAndCount(node.right);
	
		int sum = node.value + leftResult[0] + rightResult[0];
		int count = 1 + leftResult[1] + rightResult[1];
	
		return new int[]{sum, count};
	}
	
}

public class main {

    public static void ex1() {
        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(10);
        tree.insert(6);
        tree.insert(7);

        tree.printTree();

        System.out.println("Searching for 6: " + tree.search(6));
        System.out.println("Searching for 9: " + tree.search(9));

        tree.delete(1);
        System.out.println("After deleting 1:");
        tree.printTree();

        tree.delete(8);
        System.out.println("After deleting 8:");
        tree.printTree();
    }

    public static void ex2_1() {
        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(6);
        tree.insert(15);
        tree.insert(7);
        tree.insert(13);
        tree.insert(11);
        tree.insert(8);
        tree.insert(2);

		double avarageNumber = tree.calculateAverage(tree.root);

		System.out.println(avarageNumber);

		tree.insert((int)avarageNumber);

        tree.printTree();
    }

    public static void ex2_2() {
		BinaryTree tree = new BinaryTree();
		int[] numbers = {456, 124, 786, 435, 788, 444, 565, 127, 458, 322, 411, 531, 400, 546, 410};

		for (int i : numbers) {
			if (i / 100 == 4) {
				tree.insert(i);
			}
		}

		tree.printInorder(tree.root);
    }

    public static void main(String[] args) {
        //ex1();
        //ex2_1();
        ex2_2();
    }
}
