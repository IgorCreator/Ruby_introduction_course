package cracking_the_code_book.trees_and_graphs;

/*
Start at the root (or another arbitrarily selected node) and explore each
branch completely before moving on to the next branch

Often preferred if we want to visit every node in the graph
* */

public class DepthFirstSearchGraph {

    public void searchDFS(Node node){
        if(node.value.isEmpty()) return;

        System.out.println("Visited: " + node.value);
        node.isVisited = true;

        for (Node child : node.children) {
            if(!child.isVisited) searchDFS(child);
        }

    }

    static class Node {
        String value;
        boolean isVisited;
        Node[] children;
    }
}
