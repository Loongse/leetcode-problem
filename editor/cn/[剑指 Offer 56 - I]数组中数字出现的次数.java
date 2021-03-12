//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 328 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int[] a = new int[2];
        int x = 0;//两个数字的异或
        for (int num : nums) {
            x ^= num;
        }
        int m = 1;
        //获取两个数字第一位不同的地方
        while ((m & x) == 0) {
            m = m << 1;
        }
        for (int num : nums) {
            if ((m & num) == 0) {
                a[0] ^= num;//与数字0此位相同的数字
            } else {
                a[1] ^= num;
            }
        }
        if (a[0] > a[1]) {
            a[0] ^= a[1];
            a[1] ^= a[0];
            a[0] ^= a[1];
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
