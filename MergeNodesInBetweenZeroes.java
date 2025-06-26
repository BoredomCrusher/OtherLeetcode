package OtherLeetcode;

public class MergeNodesInBetweenZeroes {
    public static void main(String[] args) {

        // 0 -> 1 -> 2 -> 0 -> 3 -> 4 -> 0
        ListNode head = makeExample();
        
        ListNode solution1 = mergeNodes(head);

        System.out.println("" + solution1.val + " " + solution1.next.val);
        System.out.println(solution1.val == 3 && solution1.next.val == 12);

        // 0 -> 1 -> 2 -> 0 -> 3 -> 4 -> 0
        head = makeExample();
        ListNode solution2 = iterativeNodes(head);
       
        System.out.println("" + solution2.val + " " + solution2.next.val);

        
        System.out.println(solution2.val == 3 && solution2.next.val == 12);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;} 
    }
 
    // Even with some optimizations, the recursive solution
    // is still more than twice as slow as the iterative solution.
    // - both run in O(n), but the iterative solution has a space
    // - complexity of O(1) while the recursive solution is still O(n)
    public static ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode();

        return recurseNodes(head.next, newHead);
    }

    public static ListNode recurseNodes(ListNode head, ListNode newHead) {
        if (head == null)
            return head;

        newHead.val = 0;

        while (head.val != 0) {
            newHead.val += head.val;
            head = head.next;
        }

        newHead.next = recurseNodes(head.next, head);

        return newHead;
    }

    public static ListNode iterativeNodes(ListNode head) {
        ListNode newNode = head.next;
        ListNode next = newNode;

        while (next != null) {
            int total = 0;

            while (next.val != 0) {
                total += next.val;
                next = next.next;
            }
            newNode.val = total;
            next = next.next;

            newNode.next = next;
            newNode = newNode.next;
        }
        return head.next;
    }

    public static ListNode makeExample() {
        ListNode node0 = new ListNode(0);
       
        node0.next = new ListNode(1);
        node0.next.next = new ListNode(2);
        node0.next.next.next = new ListNode(0);
        node0.next.next.next.next = new ListNode(3);
        node0.next.next.next.next.next = new ListNode(4);
        node0.next.next.next.next.next.next = new ListNode(5);
        node0.next.next.next.next.next.next.next = new ListNode(0);

        return node0;
    }
}
