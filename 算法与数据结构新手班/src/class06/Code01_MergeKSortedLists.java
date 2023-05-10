package class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 K 个升序链表
 */
public class Code01_MergeKSortedLists {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                // 将list里面存储的所有链表的头结点放入heap中,在heap中自定义了Comparator,自动从小到大排序
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        // 所有链表的头结点中最小的节点弹出
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            // 将弹出的节点的next节点放入heap
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                // 将弹出的节点的next节点放入heap
                heap.add(cur.next);
            }
        }
        return head;
    }
}
