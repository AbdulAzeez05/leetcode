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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp=head;
        int l=0;
        while(temp!=null)
        {
            l++;
            temp=temp.next;
        }
        l=l-n;
        temp=dummy;
        while(l>0)
        {
            l--;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        


        return dummy.next;


        
    }
}