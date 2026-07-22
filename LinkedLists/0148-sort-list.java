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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next== null) return head;
        ListNode mid=findMid(head);
        ListNode head1=sortList(head);
        ListNode head2=sortList(mid);
        ListNode res=merge(head1,head2);
        return res;
        
    }
    public ListNode findMid(ListNode L)
    {
        ListNode fast=L;
        ListNode slow=L;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        return temp;
    }
    public ListNode merge(ListNode List1,ListNode List2)
    {
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        while(List1!=null && List2!=null)
        {
            if(List1.val<=List2.val)
            {
                temp.next=List1;
                List1=List1.next;
            }
            else
            {
                temp.next=List2;
                List2=List2.next;
            }
            temp=temp.next;
        }
        if(List1!=null)
        {
            temp.next=List1;

        }
        else
        {
            temp.next=List2;
        }
        return dummy.next;

    }
    
}
