/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-20
*/
class RemoveDuplicatesFromSortedList_83{
    
    public ListNode remove(ListNode head){
        ListNode h = head;


        return h;
    }

    public void test(){
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1);
        n0.next = n1;
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(3);
        n3.next = n4;
        Utils.printLinkedList(n0);
    }
}