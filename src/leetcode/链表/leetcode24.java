package leetcode.链表;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 */
public class leetcode24 {


    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while(pre.next !=null&&pre.next.next!=null){
            ListNode l1 = pre.next,l2 = pre.next.next;
            ListNode next = l2.next;
            pre.next = l2;
            l2.next = l1;
            l1.next = next;
            pre = l1;
        }
        return node.next;
    }
}
