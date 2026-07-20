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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1=headA;
        ListNode curr2=headB;
        int l1=0;
        int l2=0;
        while(curr1!=null)
        {
            l1++;
            curr1=curr1.next;

        }
        while(curr2!=null)
        {
            l2++;
            curr2=curr2.next;
        }
        if(l1>=l2) return intersect(l1-l2,headA,headB);
        else return intersect(l2-l1,headB,headA);
        
    }
    public ListNode intersect(int x,ListNode a,ListNode b)
    {
        ListNode l1=a;
        ListNode l2=b;
        for(int i=0;i<x;i++)
        {
            l1=l1.next;
        }
        while(l1!=null && l2!=null)
        {
            if(l1==l2) return l1;
            l1=l1.next;
            l2=l2.next;
        }
        return null;

    }
}
