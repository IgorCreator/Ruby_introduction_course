package cracking_the_code_book.trees_and_graphs;

import java.util.Arrays;
import java.util.List;

public class ArrayToTree {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 5, 11, 26, 78, 99, 154, 208, 333);

        createMinBST(integers);
    }

    private static Tree createMinBST(List<Integer> integers){
        return new Tree(createMinBST(integers, 0, integers.size() - 1));
    }

    private static Node createMinBST(List<Integer> integers, int start, int end){
        if(end < start){
            return null;
        }

        int mid = (start + end) / 2;

        Node node = new Node(integers.get(mid));
        node.left = createMinBST(integers, start, mid - 1);
        node.right = createMinBST(integers, mid + 1, end);
        return  node;
    }

    static class Tree{
        Node head;

        public Tree(Node head) {
            this.head = head;
        }
    }


    static class Node {
        int value;
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

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
