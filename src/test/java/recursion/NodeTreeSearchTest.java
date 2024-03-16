package recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodeTreeSearchTest {

    private Node<Integer> root;

    private final NodeTreeSearch nodeTreeSearch = new NodeTreeSearch();

    @BeforeEach
    public void createTree() {
        root = new Node<>(0);

        Node<Integer> node1 = root.addChild(new Node<>(1));

        Node<Integer> node11 = node1.addChild(new Node<>(11));
        Node<Integer> node111 = node11.addChild(new Node<>(111));
        Node<Integer> node112 = node11.addChild(new Node<>(112));

        Node<Integer> node12 = node1.addChild(new Node<>(12));

        Node<Integer> node2 = root.addChild(new Node<>(2));

        Node<Integer> node21 = node2.addChild(new Node<>(21));
        Node<Integer> node211 = node2.addChild(new Node<>(22));
    }

    @Test
    public void node_tree_sums_to_12() {
        nodeTreeSearch.findNode(root, 12);
        assertTrue(nodeTreeSearch.sumExists());
    }

    @Test
    public void node_tree_sums_to_13() {
        nodeTreeSearch.findNode(root, 13);
        assertTrue(nodeTreeSearch.sumExists());
    }

    @Test
    public void node_tree_sums_to_123() {
        nodeTreeSearch.findNode(root, 123);
        assertTrue(nodeTreeSearch.sumExists());
    }

    @Test
    public void node_tree_sums_to_23() {
        nodeTreeSearch.findNode(root, 23);
        assertTrue(nodeTreeSearch.sumExists());
    }

    @Test
    public void node_tree_sums_to_24() {
        nodeTreeSearch.findNode(root, 24);
        assertTrue(nodeTreeSearch.sumExists());
    }

    @Test
    public void node_tree_sums_to_124() {
        nodeTreeSearch.findNode(root, 124);
        assertTrue(nodeTreeSearch.sumExists());
    }

    @Test
    public void node_tree_does_not_sum_to_666() {
        nodeTreeSearch.findNode(root, 666);
        assertFalse(nodeTreeSearch.sumExists());
    }
}
