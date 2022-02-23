package cracking_the_code_book.linked_list;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(10);
        LinkedListNode b = new LinkedListNode(20);
        LinkedListNode c = new LinkedListNode(30);
        LinkedListNode d = new LinkedListNode(40);
        LinkedListNode e = new LinkedListNode(90);
        LinkedListNode f = new LinkedListNode(100);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        deleteMiddle(a);
        deleteElement(a);
    }

    public static LinkedListNode deleteMiddle(LinkedListNode head) { //O(n)
        int height = 0;

        LinkedListNode cur = head;
        while(cur != null){
            cur = cur.next;
            height++;
        }

        System.out.println(height);
        int mid = height/2;
        System.out.println(mid);
        LinkedListNode runner = head;
        for(int i = 1; i < mid - 1; i++){
            runner = runner.next;
        }

        int deleting = runner.next.data;
        runner.next = runner.next.next;
        System.out.println("Deleted el: " + deleting);
        return runner.next;
    }

    public static boolean deleteElement(LinkedListNode nodeToDelete) { //O(1)
        if(nodeToDelete != null && nodeToDelete.next == null){
            return false;
        } else {
            nodeToDelete.data = nodeToDelete.next.data;
            nodeToDelete.next = nodeToDelete.next.next;
            return true;
        }
    }

}
