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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0);
        Map<Integer,ListNode> map=new HashMap<>();
        dummy.next=head;
        map.put(0,dummy);
        int sum=0;
        ListNode temp=head;
        while(temp!=null)
        {
            sum+=temp.val;
            map.put(sum,temp);
            temp=temp.next;
        }
        temp=dummy;
        sum=0;
        while(temp!=null)
        {
            sum+=temp.val;
            temp.next=map.get(sum).next;
            temp=temp.next;

        }
        return dummy.next;

        
    }
}