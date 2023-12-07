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
        ListNode i=head;
        int n=0;
        
        while(i!=null)
        { 
           
            n++;
            i=i.next;
        }
        if(n==0)
        return head;
        k=k%n;
        if(n==0 || n==1 ||k==0 || k==n)
        return head;

       
         n=n-k-1;
         i=head;
         while(n>0)
        {  
          
           i=i.next;
           
           n--;
        }
         ListNode j=i.next;
         ListNode o=i.next;
         i.next=null;
         k--;
        
        while(k>0 && j.next !=null)
        {
             
              j=j.next;
        
            k--;
        }
        
    
        j.next=head;
        
        return o;
    }
}
