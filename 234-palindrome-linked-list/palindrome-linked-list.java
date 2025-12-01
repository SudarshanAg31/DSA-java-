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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode prv=null;
        ListNode curr=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            curr.next=prv;
            prv=curr;
            curr=slow;
        }
        if(fast!=null&&fast.next==null){
            slow=slow.next;
        }
        while(prv!=null&&slow!=null){
            if(prv.val!=slow.val){
                return false;
            }
            prv=prv.next;
            slow=slow.next;
        }
        return true;
    }
}