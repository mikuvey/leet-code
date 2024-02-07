public class myLinkedList{
    int val;
    myLinkedList next;

    myLinkedList(){}
    myLinkedList(int val){
        this.val = val;
    }
    
    myLinkedList(int val, myLinkedList next){
        this.val = val;
        this.next = next;
    }

}