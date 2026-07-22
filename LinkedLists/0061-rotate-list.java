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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode x=head;
        int n=0;
        while(x!=null)
        {
            n++;
            x=x.next;

        }
        k=k%n;
        if(k==0) return head;
        head=reverse(head);
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        for(int i=0;i<k && temp.next!=null;i++ )
        {
            temp=temp.next;
        }
        ListNode curr=reverse(temp.next);
        temp.next=null;
        head=reverse(head);
        temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=curr;
        return head;

        
    }
    public ListNode reverse(ListNode l)
    {
        ListNode prev=null;
        ListNode curr=l;
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
