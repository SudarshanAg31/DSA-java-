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
    public int countnum(ListNode temp){
        int count =0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=countnum(head);
        if(n==count)return head.next;
        ListNode temp=head;
        for(int i=1;i<count-n;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    return head;
    }
}