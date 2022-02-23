package cracking_the_code_book.trees_and_graphs;

public class BinaryTreeTraversal {

    public static void main(String[] args) {

    }

    // visit left, current and right nodes
    // i.e. visit node in ascending order
    public void inOrderTraversal(Node node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.println(node.value);
            inOrderTraversal(node.right);
        }
    }

    // visit current and after left and after right nodes
    // i.e. root node is always first, before any children
    public void preOrderTraversal(Node node){
        if(node != null){
            System.out.println(node.value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    // visit left and right nodes and only after current
    // i.e. children before(always first) root node
    public void postOrderTraversal(Node node){
        if(node != null){
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
            System.out.println(node.value);
        }
    }

    static class Node {
        String value;
        Node left;
        Node right;
        //Node[] children;
    }
}
