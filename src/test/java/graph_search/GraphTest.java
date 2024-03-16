package graph_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {
    private Graph g;

    @BeforeEach
    public void setUp() {
        Map<Integer, Node> nodeLookup = new HashMap<>();

        Node node_10 = new Node(10);
        Node node_9 = new Node(9);
        Node node_8 = new Node(8);
        Node node_7 = new Node(7);
        Node node_6 = new Node(6);
        Node node_5 = new Node(5);
        Node node_4 = new Node(4, node_8, node_9, node_10);
        Node node_3 = new Node(3, node_6, node_7);
        Node node_2 = new Node(2, node_4, node_5, node_6);
        Node node_1 = new Node(1, node_2, node_3);

        // Circular scenarios
        node_3.getAdjacent().add(node_1);

        nodeLookup.put(1, node_1);
        nodeLookup.put(2, node_2);
        nodeLookup.put(3, node_3);
        nodeLookup.put(4, node_4);
        nodeLookup.put(5, node_5);
        nodeLookup.put(6, node_6);
        nodeLookup.put(7, node_7);
        nodeLookup.put(8, node_8);
        nodeLookup.put(9, node_9);
        nodeLookup.put(10, node_10);
        g = new Graph(nodeLookup);
    }

    @Test
    public void depthFirstSearch() {
        assertTrue(g.hasPathDepthFirstSearch(2, 10));
        assertFalse(g.hasPathDepthFirstSearch(3, 10));
    }

    @Test
    public void breadthFirstSearch() {
        assertTrue(g.hasPathBreadthFirstSearch(2, 10));
        assertFalse(g.hasPathBreadthFirstSearch(3, 10));
    }
}
