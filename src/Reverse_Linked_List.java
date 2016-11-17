import util.ListNode;
import util.ListNodePrint;

import java.util.List;
import java.util.ListResourceBundle;

/**
 * Created by pengli on 11/17/2016.
 */
public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode node = head.next;
        head.next = null;
        ListNode pre = head;
        while(node != null){
            ListNode temp = node;
            node = node.next;
            temp.next = pre;
            pre = temp;
        }
        return  pre;
    }


    public static void main(String[] args) {
        ListNodePrint.print(new Reverse_Linked_List().reverseList(init()));
    }

    private static ListNode init() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        return head;
    }

}
