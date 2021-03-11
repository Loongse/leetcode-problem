//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1190 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> n = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
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
        for (int i = x; i < n.size(); i++) {
            Collections.swap(n,i,x);
            dfs(x+1);
            Collections.swap(n,i,x);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
