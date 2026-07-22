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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
              slow = slow.next;
            fast = fast.next.next;
        }

        ListNode r=reverse(slow.next);
        slow.next=null;

        ListNode curr=head;
        while(r!=null)
        {
            ListNode temp1=curr.next;
            ListNode temp2=r.next;

            curr.next=r;
            r.next=temp1;

            curr=temp1;
            r=temp2;

        }


        
    }
    public ListNode reverse (ListNode l)
    {
        ListNode curr=l;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;

    }
}
