import util.ListNode;

import java.util.List;

/**
 * Created by Alvin on 16/11/30.
 */
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode node = headA;
        int m =0,n=0;
        while(node.next !=null){
            node = node.next;
            m++;
        }
        node = headB;
        while(node.next !=null){
            node = node.next;
            n++;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(m > n){
          a = a.next;
            m--;
        }
        while(m < n){
            b = b.next;
            n--;
        }
        while(a != b && a != null && b != null){
            a = a.next;
            b = b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
       // node5.next = node6;
        node6.next = node7;
        node1.next = node2;
        node3.next = node4;
        node2.next = node5;
       // node4.next= node5;

        System.out.println(new Intersection_of_Two_Linked_Lists().getIntersectionNode(node1,node3).val);
    }
}
