/*Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

Solution:
1. Initialize four variables to keep track of the top, bottom, left and right boundaries of the matrix
2. Initialize a variable to keep track of the direction of traversal
3. Traverse the matrix in the direction indicated by the direction variable and update the boundaries accordingly
4. Repeat steps 2 and 3 until the top and bottom boundaries cross each other or the left and right boundaries cross each other

*/
import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result=new ArrayList<>();
        if (matrix.length==0) {
            return result;
        }
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        while(top <= bottom && left <= right){
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right){
                for (int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
    
}
