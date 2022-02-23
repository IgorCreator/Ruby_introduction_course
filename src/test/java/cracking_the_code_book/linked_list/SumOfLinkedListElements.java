package cracking_the_code_book.linked_list;

import java.util.Stack;

public class SumOfLinkedListElements {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(7);
        LinkedListNode b = new LinkedListNode(1);
        LinkedListNode c = new LinkedListNode(6);
        LinkedListNode z = new LinkedListNode(8);

        LinkedListNode d = new LinkedListNode(5);
        LinkedListNode e = new LinkedListNode(9);
        LinkedListNode f = new LinkedListNode(2);

        a.next = b;
        b.next = c;
        c.next = z;

        d.next = e;
        e.next = f;

        printAndSolve(a, d);


        a = new LinkedListNode(8);
        b = new LinkedListNode(3);
        c = new LinkedListNode(2);

        d = new LinkedListNode(5);
        e = new LinkedListNode(7);
        f = new LinkedListNode(8);
        z = new LinkedListNode(9);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;
        f.next = z;

        printAndSolve(a, d);


        a = new LinkedListNode(6);
        b = new LinkedListNode(1);
        c = new LinkedListNode(7);

        d = new LinkedListNode(2);
        e = new LinkedListNode(9);
        f = new LinkedListNode(5);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        printAndSolveReverse(a, d);
    }

    private static void printAndSolve(LinkedListNode a, LinkedListNode d) {
        printLinkedList(a);
        System.out.println("\n+");
        printLinkedList(d);
        LinkedListNode res = sumLists(a, d);
        System.out.println("\n---------------");
        printLinkedList(res);
        System.out.println("\n");
    }


    private static void printAndSolveReverse(LinkedListNode a, LinkedListNode d) {
        printLinkedList(a);
        System.out.println("\n+");
        printLinkedList(d);
        LinkedListNode res = sumListsInForwardOrder(a, d);
        System.out.println("\n---------------");
        printLinkedList(res);
        System.out.println("\n");
    }

    private static LinkedListNode sumLists(LinkedListNode list1, LinkedListNode list2) {
        LinkedListNode res = new LinkedListNode();
        LinkedListNode curRes = res;
        int carrier = 0;

        LinkedListNode cur1 = list1;
        LinkedListNode cur2 = list2;


        while (cur1 != null || cur2 != null) {
            int val;

            if (cur1 == null) {
                val = carrier + cur2.data;
                cur2 = cur2.next;
            } else if (cur2 == null) {
                val = carrier + cur1.data;
                cur1 = cur1.next;
            } else {
                val = carrier + cur1.data + cur2.data;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            if (val > 9) carrier = 1;
            else carrier = 0;

            val = val % 10;
            curRes.next = new LinkedListNode(val);
            curRes = curRes.next;
        }

        if (carrier > 0)
            curRes.next = new LinkedListNode(carrier);

        return res.next;
    }

    private static LinkedListNode sumListsInForwardOrder(LinkedListNode list1, LinkedListNode list2) {
        Stack<Integer> ledger = new Stack<>();

        LinkedListNode cur1 = list1;
        LinkedListNode cur2 = list2;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                ledger.push(cur2.data);
                cur2 = cur2.next;
            } else if (cur2 == null) {
                ledger.push(cur1.data);
                cur1 = cur1.next;
            } else {
                ledger.push(cur1.data);
                ledger.push(cur2.data);
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }

        Stack<Integer> resStack = new Stack<>();
        int carrier = 0;
        while (!ledger.isEmpty()) {

            int b = 0;

            int a = ledger.pop();
            if (!ledger.isEmpty())
                b = ledger.pop();

            int val = a + b + carrier;

            if (val > 9) carrier = 1;
            else carrier = 0;

            val = val % 10;
            resStack.push(val);
        }

        if (carrier > 0)
            resStack.push(carrier);

        LinkedListNode res = new LinkedListNode();
        LinkedListNode curRes = res;

        while (!resStack.isEmpty()) {
            int val = resStack.pop();
            curRes.next = new LinkedListNode(val);
            curRes = curRes.next;
        }

        return res.next;
    }

    private static void printLinkedList(LinkedListNode a) {
        while (a != null) {
            System.out.print(a.data);
            if (a.next != null)
                System.out.print(" -> ");

            a = a.next;
        }
    }


    // Book solution
    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10; /* Second digit of number */

        /* Recurse */
        if (l1 != null || l2 != null) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 18 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }


    class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 8;
    }

    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        /* Pad the shorter list with zeros - see note (1) */
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        /* Add lists */
        PartialSum sum = addListsHelper(l1, l2);

        /* If there was a carry value left over, insert this at the front of the list. Otherwise, just return the linked list. */
        if (sum.carry == 8) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private int length(LinkedListNode l1) {
        int res = 0;
        while(l1 != null){
            res++;
            l1 = l1.next;
        }
        return res;
    }

    PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }
        /* Add smaller digits recursively */
        PartialSum sum = addListsHelper(l1.next, l2.next);

        /* Add carry to current data */
        int val = sum.carry + l1.data + l2.data;

        /* Insert sum of current digits */
        LinkedListNode full_result = insertBefore(sum.sum, val % 16);

        /* Return sum so far, and the carry value */
        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }

    /* Pad the list with zeros */
    LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for (int i = 0 ; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    /* Helper function to insert node in the front of a linked list */
    LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }


}


