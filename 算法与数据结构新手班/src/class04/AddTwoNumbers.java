package class04;

import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;
        int carry = 0;
        int curNum = 0;
        // 第一阶段:短链表有,长链表有
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            // 当前节点的值
            curL.val = (curNum % 10);
            // 是否有进位
            carry = curNum / 10;
            // 保留节点,当最后一个节点为9,然后又进位到1时需要生成新节点时,因为此时curL为null,所以记录下当前的这个最后一个节点
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        // 第二阶段:短链表没有,长链表有
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        // 第三阶段:短链表没有,长链表也没有,判断是否需要进位从而生成一个新的进位后的节点1
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 求链表长度
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
