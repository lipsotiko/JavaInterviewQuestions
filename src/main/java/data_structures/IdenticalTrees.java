package data_structures;

public class IdenticalTrees {

    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    boolean identicalTrees(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 != null && tree2 != null && tree1.val == tree2.val) {
            return identicalTrees(tree1.left, tree2.left) && identicalTrees(tree1.right, tree2.right);
        }

        return false;
    }
}
