package easy;

public class MiddleOfTheLinkedList {

    private int fullDepth;
    private int counter;

    public ListNode middleNode(ListNode head) {
        checkDepth(head);
        System.out.println("depth of Nodes " + fullDepth);
        counter = (fullDepth + 1) / 2;
        return getRez(head);
    }

    private ListNode getRez(ListNode head) {
        if(fullDepth != counter){
            fullDepth--;
            return getRez(head.next);
        } else
            return head;
    }

    private void checkDepth(ListNode head) {
        fullDepth++;
        if (head.next != null) {
            System.out.println("Value of node: " + head.val);
            checkDepth(head.next);
        }
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }
    }
}
