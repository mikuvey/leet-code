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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Edge Case
        if(head == null || head.next == null){
            return head.next;
        }
        //Brute force -> Reverse list then start counting till the nth node O(2n)
        //Let's try the binary search way?
        //Check neet solution after trying

        ListNode slow = head; 
        ListNode fast = head.next;
        int fastCount = 2;
        int slowCount = 0; 

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            slowCount++;
            fastCount = fastCount + 2;
        }

        if(fast == null){
            fastCount--;
        }

        //Check where n value lies
        int idx = fastCount - n; //Index from forward
        int itrs = 0;
        ListNode start = head;

        if(idx > slowCount){
            start = slow;
            itrs = idx - slowCount;
        }
        else{
            itrs = idx;
        }

        //Perform traversal to remove the nth node
        int count = 0;
        ListNode prev = null;

        while(count < itrs){
            prev = start;
            start = start.next;
            count++;
        }

        if(prev == null || prev.next == null){
            head = start.next;
        }
        else{
            prev.next = start.next; //Removing the node
        }

        return head;
    }
}