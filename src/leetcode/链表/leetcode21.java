package leetcode.链表;

import org.w3c.dom.NodeList;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(-1);
        ListNode result = temp;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }

        if(l1!=null){
            temp.next = l1;
        }else {
            temp.next = l2;
        }

        return result.next;

//        if(l1 == null){
//            return l2;
//        }
//        if(l2 == null){
//            return l1;
//        }
//
//        if(l1.val < l2.val){
//            l1.next = mergeTwoLists(l1.next,l2);
//            return l1;
//        }
//        else {
//            l2.next = mergeTwoLists(l1,l2.next);
//            return l2;
//        }
    }
}
