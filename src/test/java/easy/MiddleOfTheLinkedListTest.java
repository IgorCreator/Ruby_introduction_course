package easy;

import easy.MiddleOfTheLinkedList.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiddleOfTheLinkedListTest {

    @Test
    public void middleNodeTest() {


        ListNode oneA = new ListNode(1);
        ListNode twoA = new ListNode(5);
        ListNode threeA = new ListNode(9);
        ListNode fourA = new ListNode(13);
        ListNode fiveA = new ListNode(17);
        ListNode sizA = new ListNode(21);

        oneA.next = twoA;
        twoA.next = threeA;
        threeA.next = fourA;
        fourA.next = fiveA;
        fiveA.next = sizA;


        ListNode rez = new ListNode(13);
        rez.next = fourA;
        fourA.next = fiveA;

        MiddleOfTheLinkedList linkedList = new MiddleOfTheLinkedList();
        assertEquals(rez, linkedList.middleNode(oneA));
    }
}