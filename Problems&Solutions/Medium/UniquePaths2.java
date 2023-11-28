/*You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1. */

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Get number of rows and columns
        int m=obstacleGrid.length;
        int n=obstacleGrid[m-1].length;

        //Initialize the dp array
        int[][] dp = new int[m][n];

        //If the starting point is an obstacle, then return 0
        if(obstacleGrid[0][0]==1){
            return 0;
        }

        //If the starting point is not an obstacle, then set the value to 1
        dp[0][0]=1;

        // Calculate the number of paths for the first row
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]==1){
                // If there is an obstacle, the number of paths is 0
                dp[0][i]=0;
            }else{
                // Otherwise, the number of paths is the same as the number of paths to the previous cell
                dp[0][i]=dp[0][i-1];
            }
        }

        // Calculate the number of paths for the first column
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]==1){
                // If there is an obstacle, the number of paths is 0
                dp[i][0]=0;
            }else{
                // Otherwise, the number of paths is the same as the number of paths to the previous cell
                dp[i][0]=dp[i-1][0];
            }
        }
        // Calculate the number of paths for the remaining cells
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                // If there is an obstacle, the number of paths is 0
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    // Otherwise, the number of paths is the sum of the number of paths to the previous cells
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }

        // Return the number of paths to the bottom-right corner
        return dp[m-1][n-1];
    }
}
