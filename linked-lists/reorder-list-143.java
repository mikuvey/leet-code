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
    public void reorderList(ListNode head) {
        /**
        1. Split the ll in two halves using slow and fast ptrs
        2. Reverse the 2nd half
        3. Merge two list alternatively */

        //Split the list
        ListNode slow = head;
        ListNode fast = head.next; //Check boundary here

        //How do I get back to the fast which has crossed? -> Make sure I could only cross by 1
        //Sol: In the while check for both -> fast != null &&  fast.next != null
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        //Reverse 2nd list
        ListNode curr = slow.next;
        ListNode prev = slow.next = null; //Important to prune 1st list from 2nd
        ListNode resrv = head;

        while(curr != null){
            resrv = curr.next;
            curr.next = prev;
            prev = curr;
            curr = resrv;
        }

        ListNode head2 = prev; 

        //Merge Lists - Dummy Node
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(head2 != null){
            ListNode temp = head.next;
            ListNode temp2 = head2.next;

            tail.next = head;
            head.next = head2;
            tail = head2;
            
            head = temp;
            head2 = temp2;
        }

        if(head != null){
            tail.next = head;
        }

    }
}