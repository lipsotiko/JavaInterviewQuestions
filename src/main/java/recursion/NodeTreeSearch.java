package recursion;

class NodeTreeSearch {

    private boolean sumExists = false;

    void findNode(Node<Integer> node, int sum) {
        int newSum = sum - node.getData();
        sumExists = (newSum == 0);

        for (Node<Integer> n : node.getChildren()) {
            if (!sumExists) findNode(n, newSum);
        }

    }

    boolean sumExists() {
        return sumExists;
    }

}
