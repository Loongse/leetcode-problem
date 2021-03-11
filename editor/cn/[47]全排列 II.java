//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 621 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> n = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums) {
            n.add(num);
        }
        dfs(0);
        return res;
    }
    void dfs(int x){
        if(x == n.size()-1){
            //添加排列
            res.add(new ArrayList<>(n));
            return ;//回溯回去
        }
        //重复数据剪枝
        HashSet<Integer> set = new HashSet<>();
        for (int i = x; i < n.size(); i++) {
            if(set.contains(n.get(i))) continue;//跳过
            set.add(n.get(i));
            Collections.swap(n,i,x);
            dfs(x+1);
            Collections.swap(n,i,x);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
