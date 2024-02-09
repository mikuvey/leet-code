/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();
        
        //1st Pass Clone each n ode
        while(curr != null){
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        //2nd Pass Connect the dots
        /*1.new copyHead, another node as currCopy
         2. In whileloop -> Node temp = curr.next(Map); currCopy.next = temp; 
         3.same way to random aswell  
         4. Update*/

        Node cloneHead = map.get(head);
        curr = head;
        Node cloneCurr = cloneHead;

        while(curr != null){
            Node tmpNext = map.get(curr.next);
            Node tmpRndm = map.get(curr.random);

            //Link
            cloneCurr.next = tmpNext;
            cloneCurr.random = tmpRndm;

            //Update
            cloneCurr = cloneCurr.next;
            curr = curr.next;
        }

        //result
        return cloneHead;
    }

    public Node copyNode(Node orginal){
        Node copy = new Node(orginal.val);
        return copy;
    }
}