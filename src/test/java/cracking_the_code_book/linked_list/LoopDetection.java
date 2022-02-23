package cracking_the_code_book.linked_list;

public class LoopDetection {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        LinkedListNode b = new LinkedListNode(7);
        LinkedListNode c = new LinkedListNode(8);
        LinkedListNode d = new LinkedListNode(5);
        LinkedListNode e = new LinkedListNode(10);
        LinkedListNode f = new LinkedListNode(2);
        LinkedListNode g = new LinkedListNode(1);

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = d;

        System.out.println(loopDetectionSolution(head).data);

    }

    //Book solution
    //#50, #69, #83, #90

    //There are really two parts to this problem. First, detect if the linked list has a loop.
    //Second, figure out where the loop starts.

    //To identify if there's a cycle, try the "runner" approach described on page 93. Have one
    //pointer move faster than the other.

    //You can use two pointers, one moving twice as fast as the other. If there is a cycle, the
    //two pointers will collide. They will land at the same location at the same time. Where do
    //they land? Why there?

    //If you haven't identified the pattern of where the two pointers start, try this: Use the
    //linked list 1->2->3->4->5->6->7->8->9->?, where the? links to another node. Try
    //making the? the first node (that is, the 9 points to the 1 such that the entire linked list
    //is a loop). Then make the? the node 2. Then the node 3. Then the node 4. What is the
    //pattern? Can you explain why this happens?
    private static LinkedListNode loopDetectionSolution(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        //This will find if we have loops
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data == fast.data) break; //collision -> loop exists
        }

        /* Error check - no meeting point, and therefore no loop */
        if (fast == null || fast.next == null) {
            return new LinkedListNode(Integer.MAX_VALUE);
        }

        //This will find where loop starts
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* Both now point to the start of the loop. */
        return fast;
    }


}
