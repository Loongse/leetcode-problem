//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 629 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //螺旋矩阵
//        从四个方向依次放入列表，每次放入对应行列修改
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int top = 0;//上
        int bottom = matrix.length - 1;//下
        int left = 0;//左
        int right = matrix[0].length - 1;//右
        while (true){
            //上
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            //判断是否完成
            if(left > right || top > bottom) break;


            //右
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            //判断是否完成
            if(left > right || top > bottom) break;

            //下
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            //判断是否完成
            if(left > right || top > bottom) break;

            //左
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            //判断是否完成
            if(left > right || top > bottom) break;

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
