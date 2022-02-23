package cracking_the_code_book.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeToLinkedList {

    public static void main(String[] args) {
        
    }

    ArrayList<LinkedList<Node>> createdLevelLinkedList(Node root){
        ArrayList<LinkedList<Node>> res = new ArrayList<>();

        LinkedList<Node> level = new LinkedList<>();
        if(root != null) level.add(root);

            while(!level.isEmpty()){
                res.add(level);
                LinkedList<Node> oldLevel = level;
                level = new LinkedList<>();

                for (Node parent : oldLevel) {
                    if(parent.left != null) {
                        level.add(parent.left);
                    }
                    if(parent.right != null) {
                        level.add(parent.right);
                    }
                }
            }
        return res;
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
