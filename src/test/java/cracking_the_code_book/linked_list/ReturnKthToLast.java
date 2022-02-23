package cracking_the_code_book.linked_list;

import cracking_the_code_book.linked_list.LinkedListNode;

public class ReturnKthToLast {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(10);
        LinkedListNode b = new LinkedListNode(20);
        LinkedListNode c = new LinkedListNode(30);
        LinkedListNode d = new LinkedListNode(90);
        LinkedListNode e = new LinkedListNode(100);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        kthToLastNode(5, a);
    }

    // #8, #25, #47, #67, # 726
    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) { //O(n)
        LinkedListNode res = head;

        int i = 0;
        LinkedListNode runner = head;
        // Move cursor on k position
        while (i <= k) {
            if (runner.next != null)
                runner = runner.next;
            else {
                throw new IllegalStateException("Such element doesn't exist");
            }

            i++;
        }

        // Go all way to the end and return res as we know that runner pointed to the end and res exactly k elements from runner.
        while (runner != null) {
            res = res.next;
            runner = runner.next;
        }

        System.out.println(res.data);
        return res;
    }

    //#8, #25, #47, #67, # 726
    // Book solution
    int printKthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }


    class Index {
        public int value = 0;
    }

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
        if (head == null) {
            return null;
        }
        LinkedListNode node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }

    LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        /* Move pi k nodes into the list. */
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // Out of bounds
            p1 = p1.next;
        }

        /* Move them at the same pace. When p1 hits the end, p2 will be at the right element . */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}