class BinaryTree{
    class Node{
        //Three fields 1. Data/value, 2. left Child, 3. Right child
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinaryTree(){root = null;}
    BinaryTree(int val){root = new Node(val);}

    
}
