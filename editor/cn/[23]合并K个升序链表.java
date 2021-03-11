//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1197 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * public ListNode mergeKLists(ListNode[] lists) {
     * //方案1：使用优先队列，把每个链表的头节点入队
     * if(lists == null || lists.length == 0) return null;
     * PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
     *
     * @Override public int compare(ListNode o1, ListNode o2) {
     * return o1.val - o2.val;
     * }
     * });
     * ListNode vir = new ListNode(0);//虚拟节点
     * ListNode cur = vir;//当前节点
     * for (ListNode list : lists) {
     * if(list != null) {
     * queue.add(list);
     * }
     * }
     * while (!queue.isEmpty()){
     * //非空就继续排序
     * cur.next = queue.poll();
     * cur = cur.next;
     * //放入取出的链表的next节点
     * if(cur.next != null){
     * queue.add(cur.next);
     * }
     * }
     * return vir.next;
     * }
     */
    //使用归并排序思想
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeKList(lists, 0, lists.length - 1);
    }

    public ListNode mergeKList(ListNode[] listNodes, int lo, int hi) {
        if (hi <= lo) return listNodes[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode left = mergeKList(listNodes, lo, mid);
        ListNode right = mergeKList(listNodes, mid + 1, hi);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode h = new ListNode(0);
        ListNode t = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                t.next = left;
                left = left.next;
            } else {
                t.next = right;
                right = right.next;
            }
            t = t.next;
        }
        if (left != null) t.next = left;
        if (right != null) t.next = right;
        return h.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
