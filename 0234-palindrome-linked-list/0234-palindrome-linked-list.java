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
        ListNode temp=head;
        int n=0;
        while(temp!=null)
        {
            temp=temp.next;
            n++;
        }
        int [] ele=new int[n];
        temp=head;
        int i=0;
        while(temp!=null)
        {
            ele[i]=temp.val;
            temp=temp.next;
            i++;
            
        }
        temp=head;
        i=n-1;
        while(temp!=null)
        {
            if(temp.val!=ele[i]) return false;
            i--;
            temp=temp.next;
        }
        return true;

        
    }
}