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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // add nodes.val and create a new node in each iteration
        //Only incase if num is greater than 9:
        //carry=1, val = num%10

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(curr1 != null || curr2 != null){
            //logic
            //get sum
            int sum = 0;
            if(curr1 == null){
                sum += curr2.val + carry;
            }
            else if(curr2 == null){
                sum += curr1.val + carry;
            }
            else{
                sum = curr1.val + curr2.val + carry;
            }
            carry = 0;

            //Check for carry
            if(sum>9){
                carry = sum/10;
                sum = sum%10;   
            }

            //Sum Node
            ListNode sumNode = new ListNode(sum);

            //update
            tail.next = sumNode;
            tail = sumNode;

            if(curr1 != null)
                curr1 = curr1.next;
            if(curr2 != null)
                curr2 = curr2.next;
        }

        if(carry>0){
            ListNode sumNode = new ListNode(carry);
            tail.next = sumNode;
            tail = sumNode;
        }

        return dummy.next;
    }
}