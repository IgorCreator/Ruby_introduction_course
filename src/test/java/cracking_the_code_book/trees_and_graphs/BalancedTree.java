package cracking_the_code_book.trees_and_graphs;

public class BalancedTree {

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

        System.out.println(isBalanced(head));
    }

    private static boolean isBalanced(Node head) {
        return checkHeight(head) != Integer.MIN_VALUE;
    }

    private static int checkHeight(Node node){
        if (node == null) return -1;

        int left = checkHeight(node.left);
        if (left == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int right = checkHeight(node.right);
        if (right == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(left - right) > 1)
            return Integer.MIN_VALUE;
        else
            return Math.max(left, right) + 1;
    }


    private static boolean isBalanced_v1(Node head) {
        if(head == null) return true;

        int diff = Math.abs(depths(head.left) - depths(head.right));
        if(diff <= 1)
            return isBalanced(head.left) && isBalanced(head.right);
        else
            return false;
    }

    private static int depths(Node node){
        if(node == null) return -1;
        int depth = Math.max(depths(node.left), depths(node.right)) + 1;
        return depth;
    }


    private static class Node {
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
