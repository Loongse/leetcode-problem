//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1569 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //head表示当前节点,pre 表示前一个节点，用于表示反转后的头，next用来存剩下的未反转部分
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;//反转
            pre = head;
            head = next;//重新遍历未反转部分
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
