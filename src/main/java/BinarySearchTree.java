import java.util.*;
public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert method
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Search method
    public boolean search(int key) {
        return searchRec(root, key) != null;
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    // Delete method
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // toString method for printing the tree
    @Override
    public String toString() {
        return root == null ? "└──" : root.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }

    // Add the toString method in the Node class similar to earlier explanation

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(23);
        tree.insert(41);
        tree.insert(75);
        tree.insert(43);
        tree.insert(81);
        tree.insert(12);
        tree.insert(34);
        tree.insert(99);
        tree.insert(101);
        tree.insert(106);

        System.out.println("TASK 1 ----------------------------------------------------");

        System.out.println("Binary Search Tree:");
        System.out.println(tree);

        tree.insert(27);
        System.out.println("Value 27 inserted into tree.");
        System.out.println(tree);

        System.out.println("Search initiated for value 34... Found: " + tree.search(34));
        System.out.println("Search initiated for value 35... Found: " + tree.search(35));

        tree.delete(34);
        System.out.println("Value 34 deleted from tree.");
        System.out.println(tree);


        System.out.println("TASK 2 ----------------------------------------------------");

        BinarySearchTree tree2 = new BinarySearchTree();
        System.out.println("New empty tree2");
        System.out.println(tree2);

        tree2.insert(15);
        tree2.insert(23);
        tree2.insert(20);
        tree2.insert(10);
        tree2.insert(13);
        tree2.insert(6);
        tree2.insert(18);
        tree2.insert(35);
        tree2.insert(9);
        tree2.insert(24);

        System.out.println("Inserted initial values into empty \"tree2\".");
        System.out.println(tree2);

        tree2.delete(6);
        System.out.println(tree2);
        tree2.delete(15);
        System.out.println(tree2);
        tree2.delete(20);
        System.out.println(tree2);
        System.out.println("Deleted values 6, 15, 20");
    }
}


