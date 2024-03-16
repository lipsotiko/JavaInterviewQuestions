package data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdenticalTreesTest {

    IdenticalTrees.Node tree1;
    IdenticalTrees.Node tree2;
    IdenticalTrees.Node tree3;
    IdenticalTrees.Node tree4;
    IdenticalTrees.Node tree5;

    @BeforeEach
    public void setUp() {
        // Regular binary trees
        tree1 = new IdenticalTrees.Node(4);
        tree1.left = new IdenticalTrees.Node(1);
        tree1.right = new IdenticalTrees.Node(3);

        tree2 = new IdenticalTrees.Node(5);
        tree2.left = new IdenticalTrees.Node(10);
        tree2.left.left = new IdenticalTrees.Node(17);
        tree2.left.right = new IdenticalTrees.Node(3);
        tree2.right = new IdenticalTrees.Node(8);

        // Binary search trees
        tree3 = new IdenticalTrees.Node(6);
        tree3.left = new IdenticalTrees.Node(3);

        tree4 = new IdenticalTrees.Node(5);
        tree4.left = new IdenticalTrees.Node(3);
        tree4.left.left = new IdenticalTrees.Node(2);
        tree4.left.left.left = new IdenticalTrees.Node(1);

        tree5 = new IdenticalTrees.Node(8);
        tree5.left = new IdenticalTrees.Node(6);
        tree5.right = new IdenticalTrees.Node(9);
        tree5.left.left = new IdenticalTrees.Node(5);
        tree5.left.right = new IdenticalTrees.Node(7);
        tree5.right.right = new IdenticalTrees.Node(10);
    }

    IdenticalTrees identicalTrees = new IdenticalTrees();

    @Test
    public void test_false() {
        assertFalse(identicalTrees.identicalTrees(tree1, tree2));
    }

    @Test
    public void test_true() {
        IdenticalTrees.Node tree3Clone = new IdenticalTrees.Node(6);
        tree3Clone.left = new IdenticalTrees.Node(3);

        assertTrue(identicalTrees.identicalTrees(tree3, tree3Clone));
    }

    @Test
    public void test_true_2() {
        assertTrue(identicalTrees.identicalTrees(tree5, tree5));
    }
}
