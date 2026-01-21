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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode h1=temp;
        ListNode h2=head;
        while(h2!=null){
            if(h2.val==val){
                h2=h2.next;
                h1.next=h1.next.next;
            }
            else{
                h1=h2;
                h2=h2.next;
            }
        }
        return temp.next;
    }
}