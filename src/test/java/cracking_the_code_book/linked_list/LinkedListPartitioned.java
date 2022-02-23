package cracking_the_code_book.linked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedListPartitioned {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(3);
        LinkedListNode b = new LinkedListNode(5);
        LinkedListNode c = new LinkedListNode(8);
        LinkedListNode d = new LinkedListNode(5);
        LinkedListNode e = new LinkedListNode(10);
        LinkedListNode f = new LinkedListNode(2);
        LinkedListNode g = new LinkedListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        printLinkedList(a);
        a = partition(a, 5);
        printLinkedList(a);

        a = partition_v1(a, 5);
        printLinkedList(a);
    }

    private static void printLinkedList(LinkedListNode a) {
        System.out.println();
        while(a != null){
            System.out.print(a.data);
            if(a.next != null)
                System.out.print(" -> ");

            a = a.next;
        }
    }

    public static LinkedListNode partition_v1(LinkedListNode node, int x) {
        List<Integer> list = new ArrayList<>();

        LinkedListNode cur = node;
        while(cur != null){
            list.add(cur.data);
            cur = cur.next;
        }

        Collections.sort(list);
        LinkedListNode res = new LinkedListNode();
        LinkedListNode runner = res;
        for (Integer data : list) {
            runner.next = new LinkedListNode(data);
            runner = runner.next;
        }
        return res.next;
    }

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                /* Insert node at head. */
                node.next = head;
                head = node;
            } else {
                /* Insert node at tail. */
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        // The head has changed, so we need to return it to the user.
        return head;
    }

}
