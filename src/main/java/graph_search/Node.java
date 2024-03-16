package graph_search;

import java.util.Arrays;
import java.util.LinkedList;

public class Node {
    private final int id;

    private boolean visited;
    private final LinkedList<Node> adjacent = new LinkedList<>();

    public Node(int id) {
        this.id = id;
        visited = false;
    }

    public Node(int id, Node... nodes) {
        this.id = id;
        this.adjacent.addAll(Arrays.asList(nodes));
        visited = false;
    }

    public int getId() {
        return id;
    }

    public LinkedList<Node> getAdjacent() {
        return adjacent;
    }

    public void setVisited() {
        visited = true;
    }

    public boolean visited() {
        return visited;
    }
}
