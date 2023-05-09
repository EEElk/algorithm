package class04;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class MergeTwoSortedLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        // 找到两个链表的头结点中较小的那个节点
        ListNode head = head1.val >= head2.val ? head2 : head1;
        // 从头节点较小的那个链表的后一个节点开始
        ListNode cur1 = head.next;
        // 从头节点较大的那个的头节点开始
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        // 当两个链表其中一个为null,则剩下的节点就是另一个链表剩下的所有节点了
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }
}
