/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        //Delete -> x.next = y.next
        //Finding the middle node -> len(n)/2
        //Brute force -> Count the no.of nodes -> traverse through the list again to the middle node (O2(n))
        //Slow and fast ptrs O(n/2) and count

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = slow;
        int slowCount = 0;
        int fastCount = 1;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

            slowCount++;
            fastCount = fastCount + 2;
        }

        if(slow.next == null){
            return null;
        }
        else if(fast == null){
            prev.next = slow.next;   
        }
        else{
            prev = slow;
            slow = slow.next;
            prev.next = slow.next;
        }

        return head;

    }
}
