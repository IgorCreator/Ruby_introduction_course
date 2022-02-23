package cracking_the_code_book.trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
Start at the root (or another arbitrarily selected node) and explore each
neighbor before going on to any of their children

Better ro use if we want to find the shortest path (or just any path) between two nodes,
* */

public class BreadthFirstSearchGraph {

    public void searchBFS(Node node){
        Queue<Node> level = new LinkedList();
        node.isVisited = true;
        level.add(node);

        while(!level.isEmpty()){
            Node curNode = level.poll();
            System.out.println("Visited: " + curNode.value);

            for (Node neighbor : curNode.neighbors) {
                if(!neighbor.isVisited) {
                    neighbor.isVisited = true;
                    level.add(neighbor);
                }
            }
        }
    }

    static class Node {
        String value;
        boolean isVisited;
        Node[] neighbors;
    }

}
