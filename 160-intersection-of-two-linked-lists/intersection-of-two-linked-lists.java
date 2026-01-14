/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getcount(ListNode temp){
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int h1_val=getcount(headA);
        int h2_val=getcount(headB);
        while(h1_val<h2_val){
            h2_val--;
            headB=headB.next;
        }
        while(h1_val>h2_val){
            h1_val--;
            headA=headA.next;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}