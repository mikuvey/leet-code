package rough;

public class IndexBinarySearchTree {
    """
            Given a BST the code's task is to find the kth smallest element in the tree.
    """
    
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public kthSmallest(Node root, int k){
        // Recursively return the kth smallest element
        int[] count = {0};
        //
        return kthSmallestUtil(root, k, count);
    }
    
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int k = 3;
        System.out.println(kthSmallest(root, k));
    }
}
