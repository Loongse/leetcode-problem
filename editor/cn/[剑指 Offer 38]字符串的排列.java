//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 203 👎 0


import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);//搜索
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x){
        if(x == c.length -1) {
            //添加排列方案
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();//用于剪纸判断
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue;//重复数据无需交换
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);//开始固定下一位字符
            swap(x,i);//恢复交换
        }
    }
    void swap(int i,int x){
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
