package util;

/**
 * Created by pengli on 11/17/2016.
 */
public class ListNodePrint {
    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val +" ->  ");
            head = head.next;
        }
    }
}
