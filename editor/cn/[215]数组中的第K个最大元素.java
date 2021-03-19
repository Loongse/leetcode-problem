//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 934 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //1使用快排
        //2使用大根堆(优先队列)
        return byLargeHeap(nums,k);
        //3使用小根堆
        //自定义堆实现
    }

    public int byQuickSort(int[] nums, int k) {
        return 1;
    }

    public int byLargeHeap(int[] nums, int k) {
        int len = nums.length;
        //使用大根堆
        PriorityQueue<Integer> largeHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            largeHeap.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            largeHeap.poll();
        }
        return largeHeap.peek();
    }

    public int bySmallHeap(int[] nums, int k) {
        return 1;
    }

    public int byHeap(int[] nums, int k) {
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
