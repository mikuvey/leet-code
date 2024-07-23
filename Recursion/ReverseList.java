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
    public ListNode reverseList(ListNode head) {
        //Base
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode revNode = reverseList(head.next);
        //We are asking to reverse the rest of the list before we transform and at the same time saving         //the last node as revNode (as it's going to be new head)
        
        head.next.next = head; //Most confusing step let me explain what's happening
        //1->2->null -> In this we need to assign 2's pointer to 1, so that's what we are doing
        //1<-2 (head.next.next)
        head.next = null;
        //null<-1<-2
        
        return revNode;
        
    }
}