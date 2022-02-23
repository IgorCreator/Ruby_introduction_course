package cracking_the_code_book.linked_list;

import cracking_the_code_book.linked_list.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromLindedList {

    public static void main(String[] args) {

    }


    public void removeDuplicates(LinkedListNode head){
        if(head == null) return;

        Set<Integer> checked = new HashSet<>();

        LinkedListNode cur = head;
        while(cur.next != null){        //O(n)
            int data = cur.next.data;
            if(checked.contains(data))
                removeNode(cur);
            else
                checked.add(data);

            cur = cur.next;
        }
    }

    private void removeNode(LinkedListNode cur) {
        cur.next = cur.next.next;
    }

    //#9, #40
    //Book Solution
    void deleteDups(LinkedListNode n) {  // O(n)
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous. next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    void deleteDups_followUp(LinkedListNode n) {  // O(n*n), space O(1)
        LinkedListNode current = n;
        while (current != null) {

            LinkedListNode runner = current;
            while(runner.next != null ){
                if(current.data == runner.next.data){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}

