package cracking_the_code_book.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class ifTreeIsBalancedSearchTree {

    public static void main(String[] args) {
        Node head = new Node(1);

        Node left = new Node(2);
        Node right = new Node(3);
        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);

        left.setLeft(node3);
        head.setLeft(left);
        node1.setLeft(node2);
        right.setRight(node1);
        head.setRight(right);

        System.out.println(isBST(head));
    }

    private static boolean isBST(Node head) {
        List<Integer> arr = new ArrayList<>();
        checkBST(head, arr);
        for(int i = 1; i < arr.size(); i++)
            if(arr.get(i) <= arr.get(i-1)) return false;

        return true;
    }

    private static void checkBST(Node node, List<Integer> arr) {
        if(node == null) return;

        checkBST(node.left, arr);
        arr.add(node.value);
        checkBST(node.right, arr);
    }


    private static boolean isBST_v2(Node head) {
        return checkBST_v2(head);
    }


    private static boolean checkBST_v2(Node node) {
        if(node == null) return true;

        if (!checkBST_v2(node.left)) return false;
        if (Wraplnt.value != null && node.value <= Wraplnt.value) {
            return false;
        }
        Wraplnt.value = node.value;

        if (!checkBST_v2(node.right)) return false;
        return true;
    }

    static class Wraplnt {
        public static Integer value = null;
    }



    boolean checkBST_v3(Node n) {
        return checkBST(n, null, null);
    }

    boolean checkBST(Node n, Integer min, Integer max) {
        if (n == null) return true;

        if ((min != null && n.value <= min) || (max != null && n.value > max))
            return false;

        if (!checkBST(n.left, min, n.value) || !checkBST(n.right, n.value, max))
            return false;

        return true;
    }

    private static class Node {
        Integer value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }


        public void setRight(Node right) {
            this.right = right;
        }
    }
}
