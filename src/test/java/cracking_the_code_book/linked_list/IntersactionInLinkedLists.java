package cracking_the_code_book.linked_list;

public class IntersactionInLinkedLists {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode(3);
        LinkedListNode b = new LinkedListNode(1);
        LinkedListNode c = new LinkedListNode(5);
        LinkedListNode d = new LinkedListNode(9);
        LinkedListNode e = new LinkedListNode(7);
        LinkedListNode f = new LinkedListNode(2);
        LinkedListNode g = new LinkedListNode(1);

        LinkedListNode k = new LinkedListNode(4);
        LinkedListNode l = new LinkedListNode(6);
        LinkedListNode m = new LinkedListNode(7);
        LinkedListNode o = new LinkedListNode(2);
        LinkedListNode p = new LinkedListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        k.next = l;
        l.next = m;
        m.next = o;
        o.next = p;

        printAndSolve(a, k);
    }

    private static void printAndSolve(LinkedListNode a, LinkedListNode d) {
        printLinkedList(a);
        System.out.println("\n+");
        printLinkedList(d);
        LinkedListNode res = intersectionPoint_v2(a, d);
        System.out.println("\n---------------");
        printLinkedList(res);
        System.out.println("\n");
    }

    private static void printLinkedList(LinkedListNode a) {
        while (a != null) {
            System.out.print(a.data);
            if (a.next != null)
                System.out.print(" -> ");

            a = a.next;
        }
    }

    // find length of list -> move cursor
    private static LinkedListNode intersectionPoint_v1(LinkedListNode one, LinkedListNode two) {
        int oneWeight = length(one);
        int twoWeight = length(two);

        LinkedListNode curOne = one;
        LinkedListNode curTwo = two;

        if (oneWeight > twoWeight) {
            curOne = moveCur(one, oneWeight - twoWeight);
        } else if(oneWeight < twoWeight) {
            curTwo = moveCur(two, twoWeight - oneWeight);
        }

        while(curOne != null && curTwo  != null){
            if(curOne.data == curTwo.data)
                return curOne;
            else{
                curOne = curOne.next;
                curTwo = curTwo.next;
            }
        }

        return new LinkedListNode();
    }

    private static LinkedListNode moveCur(LinkedListNode list, int i) {
        LinkedListNode res = list;
        while(i > 0){
            res = res.next;
            i--;
        }
        return res;
    }

    private static int length(LinkedListNode list) {
        int res = 0;
        while(list != null){
            res++;
            list = list.next;
        }
        return res;
    }

    // reverse orig, walk through
    private static LinkedListNode intersectionPoint_v2(LinkedListNode one, LinkedListNode two) {
        LinkedListNode reverseOne = reverse(one);
        LinkedListNode reverseTwo = reverse(two);

        LinkedListNode res = null;

        while(reverseOne != null && reverseTwo != null){
            if(reverseOne.data != reverseTwo.data)
                return res;
            else{
                LinkedListNode node = new LinkedListNode(reverseOne.data);
                node.next = res;
                res = node;

                reverseOne = reverseOne.next;
                reverseTwo = reverseTwo.next;
            }
        }

        return res;
    }

    private static LinkedListNode reverse(LinkedListNode orig) {
        LinkedListNode reversed = null;
        while(orig != null){
            LinkedListNode node = new LinkedListNode(orig.data);
            node.next = reversed;
            reversed = node;
            orig = orig.next;
        }

        return reversed;
    }

    //Solution
    LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) return null;

        /* Get tail and sizes. */
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        /* If different tail nodes, then there's no intersection. */
        if (result1.tail != result2.tail) {
            return null;
        }

        /* Set pointers to the start of each linked list. */
        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;

        /* Advance the pointer for the longer linked list by difference in lengths. */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        /* Move both pointers until you have a collision. */
        while (shorter != longer) {
            shorter = shorter. next;
            longer = longer. next;
        }

        /* Return either one. */
        return longer;
    }

    class Result {
        public LinkedListNode tail;
        public int size;
        public Result(LinkedListNode tail, int size) {
            this. tail = tail;
            this.size = size;
        }
    }

    Result getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;
        while (current. next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

}
