package cracking_the_code_book.linked_list;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromLinkedList {

    public static void main(String[] args) {
        caseOne();
        caseTwo();
        caseThree();
    }

    public static void caseOne() {
        LinkedListNode a = new LinkedListNode(7);
        LinkedListNode b = new LinkedListNode(1);
        LinkedListNode c = new LinkedListNode(6);
        LinkedListNode z = new LinkedListNode(8);
        LinkedListNode d = new LinkedListNode(6);
        LinkedListNode e = new LinkedListNode(1);
        LinkedListNode f = new LinkedListNode(7);

        a.next = b;
        b.next = c;
        c.next = z;
        z.next = d;
        d.next = e;
        e.next = f;

        printLinkedList(a);
        assertTrue(isPalindrome(a));
    }

    public static void caseTwo() {
        LinkedListNode a = new LinkedListNode(7);
        LinkedListNode b = new LinkedListNode(1);
        LinkedListNode c = new LinkedListNode(6);
        LinkedListNode d = new LinkedListNode(6);
        LinkedListNode e = new LinkedListNode(1);
        LinkedListNode f = new LinkedListNode(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        printLinkedList(a);
        assertTrue(isPalindromeLinkedList(a));

    }

    public static void caseThree() {
        LinkedListNode a = new LinkedListNode(7);
        LinkedListNode b = new LinkedListNode(1);
        LinkedListNode c = new LinkedListNode(6);
        LinkedListNode e = new LinkedListNode(1);
        LinkedListNode f = new LinkedListNode(8);

        a.next = b;
        b.next = c;
        c.next = e;
        e.next = f;

        printLinkedList(a);
        assertFalse(isPalindrome(a));
    }

    private static void printLinkedList(LinkedListNode a) {
        System.out.println();
        while (a != null) {
            System.out.print(a.data);
            if (a.next != null)
                System.out.print(" -> ");

            a = a.next;
        }
    }

    private static boolean isPalindrome(LinkedListNode a) {

        Stack<Integer> db = new Stack<>();
        LinkedListNode cur = a;

        while(cur != null){
            db.push(cur.data);
            cur = cur.next;
        }

        int rounds = db.size() / 2;

        cur = a;
        for(int i = rounds; i > 0; i--){
            Integer fromEnd = db.pop();
            Integer fromBeginning = cur.data;
            if(!fromEnd.equals(fromBeginning)) return false;
            cur = cur.next;
        }

        return true;
    }


    // Book solution
    private static boolean isPalindromeLinkedList(LinkedListNode orig) {
        LinkedListNode reversed = reverseAndClone(orig);
        return isEqual(reversed, orig);
    }

    private static LinkedListNode reverseAndClone(LinkedListNode orig) {
        LinkedListNode reversed = new LinkedListNode();
        while(orig != null){
            LinkedListNode node = new LinkedListNode(orig.data);
            node.next = reversed;
            reversed = node;
            orig = orig.next;
        }

        return reversed;
    }

    private static boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }


    boolean isPalindromeIterationWithStack(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        /* Push elements from first half of linked list onto stack. When fast runner
         * (which is moving at 2x speed) reaches the end of the linked list, then we
         * know we're at the middle */
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Has odd number of elements, so skip the middle element */
        if (fast != null) {
            slow = slow. next;
        }

        while (slow != null) {
            int top = stack.pop();

            /* If values are different, then it's not a palindrome */
            if (top != slow.data) {
                return false;
            }
            slow = slow. next;
        }
        return true;
    }
}
