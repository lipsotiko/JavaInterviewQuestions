package graph_search;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Integer, Node> nodeLookup;

    public Graph(Map<Integer, Node> nodeLookup) {
        this.nodeLookup = nodeLookup;
    }

    public boolean hasPathDepthFirstSearch(int source, int destination) {
        Node s = nodeLookup.get(source);
        Node d = nodeLookup.get(destination);
        return hasPathDepthFirstSearch(s, d);
    }

    private boolean hasPathDepthFirstSearch(Node source, Node destination) {
        if (source.visited()) {
            return false;
        }

        source.setVisited();
        if (source == destination) {
            return true;
        }

        for (Node child : source.getAdjacent()) {
            if (hasPathDepthFirstSearch(child, destination)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBreadthFirstSearch(int source, int destination) {
        List<Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(nodeLookup.get(source));

        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove(0);
            if (node == nodeLookup.get(destination)) {
                return true;
            }

            if (node.visited()) {
                continue;
            }

            node.setVisited();

            nextToVisit.addAll(node.getAdjacent());
        }

        return false;
    }
}
