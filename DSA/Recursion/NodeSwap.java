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
    public ListNode swapPairs(ListNode head) {
        //Base
        if(head == null || head.next == null){
            return head;
        }
        
        //Declare nodes
        ListNode firstNode = head;
        ListNode secondNode = firstNode.next;
        
        //swap
        firstNode.next = swapPairs(secondNode.next);  //Important logic Too good implementation
        secondNode.next = firstNode;
        
        return secondNode;
    }
}