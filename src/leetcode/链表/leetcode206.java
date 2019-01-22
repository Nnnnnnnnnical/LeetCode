package leetcode.链表;

/**
 * 反转一个单链表。
 */
public class leetcode206 {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
