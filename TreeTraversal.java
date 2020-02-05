public class TreeTraversal {
    private Node root; // root of the binary search tree

    // Representation of a binary search tree
    private class Node {
        private String item;      // node item
        private Node left, right; // left and right subtrees

        // Construct a Node given its item.
        public Node(String item) {
            this.item = item;
        }
        
        // Return a string representation of the node.
        public String toString() {
            return item;
        }
    }

    // Put the item into the tree.
    public void put(String item) {
        root = put(root, item);
    }

    // Helper for put(String item).
    private Node put(Node x, String item) {
        if (x == null) return new Node(item);
        int cmp = item.compareTo(x.item);
        if      (cmp < 0) x.left  = put(x.left,  item);
        else if (cmp > 0) x.right = put(x.right, item);
        return x;
    }

    // Return the nodes of the tree traversed pre-order.
    public Iterable<Node> preOrder() {
        // Initialize return iterable.
        Queue<Node> q = new Queue<Node>();
        // Delegate to helper method.
        preOrder(root, q);
        // Return the nodes of the tree traversed pre-order.
        return q;
    }

    // Helper for preOrder().
    private void preOrder(Node x, Queue<Node> q) {
        // Set base case.
        if (x == null) {
            return;
        }
        // Enqueue the node.
        q.enqueue(x);
        // Recurse left then right.
        preOrder(x.left, q);
        preOrder(x.right, q);
        //return to caller.
        return;
    }

    // Return the nodes of the tree traversed in-order.
    public Iterable<Node> inOrder() {
        // Initialize return iterable.
        Queue<Node> q = new Queue<Node>();
        // Delegate to helper method.
        inOrder(root, q);
        // Return the nodes of the tree traversed in-order.
        return q;
    }

    // Helper for inOrder().
    private void inOrder(Node x, Queue<Node> q) {
        // Set base case.
        if (x == null) {
            return;
        }
        // Recurse left.
        inOrder(x.left, q);
        // Enqueue the node.
        q.enqueue(x);
        // Recurse right.
        inOrder(x.right, q);
        //return to caller.
        return;
    }

    // Return the nodes of the tree traversed post-order.
    public Iterable<Node> postOrder() {
        // Initialize return iterable.
        Queue<Node> q = new Queue<Node>();
        // Delegate to helper method.
        postOrder(root, q);
        // Return the nodes of the tree traversed post-order.
        return q;
    }

    // Helper for postOrder().
    private void postOrder(Node x, Queue<Node> q) {
        // Set base case.
        if (x == null) {
            return;
        }
        // Recurse left then right.
        postOrder(x.left, q);
        postOrder(x.right, q);
        // Enqueue the node.
        q.enqueue(x);
        //return to caller.
        return;
    }

    // Return the nodes of the tree traversed level-order.
    public Iterable<Node> levelOrder() {
        // Initialize current node tracking queue.
        Queue<Node> visitedNode = new Queue<Node>();
        // Initialize return iterable queue.
        Queue<Node> returnNode = new Queue<Node>();
        // Account for empty table.
        if (root == null) {
            return returnNode;
        } else {
            // Load root into node tracker.
            visitedNode.enqueue(root);
        }
        // Evaluate while node tracker queue is not empty.
        while (!visitedNode.isEmpty()) {
            // Remove node from queue to be evaluated.
            Node current = visitedNode.dequeue();
            // Load children into node tracking queue if they are not null.
            if (current.left != null) {
                visitedNode.enqueue(current.left);
            }
            if (current.right != null) {
                visitedNode.enqueue(current.right);
            }
            // Load evaluated node into return queue.
            returnNode.enqueue(current);
        }
        // Return queue with points in level order.
        return returnNode;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] items = StdIn.readAllStrings();
        TreeTraversal tree = new TreeTraversal();
        for (String item : items) {
            tree.put(item);
        }
        StdOut.println("Pre-order:   " + tree.preOrder());
        StdOut.println("In-order:    " + tree.inOrder());
        StdOut.println("Post-order:  " + tree.postOrder());
        StdOut.println("Level-order: " + tree.levelOrder());
    }
}
