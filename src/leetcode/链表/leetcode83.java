package leetcode.链表;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class leetcode83 {

    public ListNode deleteDuplicates(ListNode head) {
        //解法1
//        if (head == null || head.next == null) return head;
//        head.next = deleteDuplicates(head.next);
//        return head.val == head.next.val ? head.next : head;

        //解法2
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            p.next = q;
            p = p.next;
        }
        return head;
    }
}
