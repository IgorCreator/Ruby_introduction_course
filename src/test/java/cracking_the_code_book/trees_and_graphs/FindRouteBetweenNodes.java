package cracking_the_code_book.trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

//        depth-first search is a bit simpler to implement since it can be done with simple recursion.
//        Breadth-first search can also be useful to find the shortest path, whereas
//        depth-first search may traverse one adjacent node very deeply before ever going onto the immediate neighbors

public class FindRouteBetweenNodes {

    //BFS implemented
    public static boolean isRouteBetweenNodes(Node start, Node end) {
        if (start.value.isEmpty() || end.value.isEmpty()) return false;

        Queue<Node> nodesToVisit = new LinkedList<>();
        nodesToVisit.add(start);
        start.isVisited = true;

        while (!nodesToVisit.isEmpty()) {
            Node considerNode = nodesToVisit.poll();
            for (Node neighbor : considerNode.children) {
                if (!neighbor.isVisited) {
                    if (neighbor.value.equals(end.value)) return true;
                    else {
                        neighbor.isVisited = true;
                        nodesToVisit.add(neighbor);
                    }
                }
            }
        }

        return false;
    }

    static class Node {
        String value;
        boolean isVisited;
        Node[] children;
    }

}
