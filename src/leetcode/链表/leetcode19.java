package leetcode.链表;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class leetcode19 {

    /**
     * 先让一个指针移动n，然后让另一个指针从head开始，同时移动，两个指针始终保持n的距离，当第一个指针到尾时，另一个指针就是倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        while(n>0){
            first = first.next;
            n--;
        }

        if(first == null){
            return head.next;
        }

        ListNode second = head;
        while(first.next != null){
            second = second.next;
            first = first.next;
        }

        second.next = second.next.next;

        return head;
    }

}
