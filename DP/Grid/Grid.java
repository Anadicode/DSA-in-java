import java.util.Arrays;

public class Grid{

    //62. Unique Paths
    class Solution {
        private int path(int i,int j, int m, int n,int [][] arr){
            if(i>=m)return 0;
            if(j>=n)return 0;
            if(i==m-1 && j==n-1)return 1;

            if(arr[i][j]!=-1)return arr[i][j];

            int l=path(i+1,j,m,n,arr);
            int d=path(i,j+1,m,n,arr);

            return arr[i][j] = l+d;
        }
        public int uniquePaths(int m, int n) {
            int [][] arr = new int [m][n];

            for(int i = 0; i < arr.length; i++) {
                Arrays.fill(arr[i], -1);
            }

            return path(0,0,m,n,arr);
        }
    }

    //63. Unique Paths II
    class Solution1 {
        private int path(int i,int j, int m, int n,int [][] arr, int [][]obstacleGrid){
            if(i>=m)return 0;
            if(j>=n)return 0;
            if(obstacleGrid[i][j]==1)return 0;
            if(i==m-1 && j==n-1)return 1;

            if(arr[i][j]!=-1)return arr[i][j];

            int l=path(i+1,j,m,n,arr,obstacleGrid);
            int d=path(i,j+1,m,n,arr,obstacleGrid);

            return arr[i][j] = l+d;
        }
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int [][]arr = new int [m][n];

            for(int i=0;i<m;i++){
                Arrays.fill(arr[i],-1);
            }

            return path(0,0,m,n,arr,obstacleGrid);
        }
    }

    //931. Minimum Falling Path Sum
    class Solution3 {


        private int pathSum(int m,int n,int i,int j, int [][]arr,int [][]matrix){
            if(i>=m)return 1000000000;
            if(j<0 || j>=n)return 1000000000;

            if(i==m-1){
                return matrix[i][j];
            }

            if(arr[i][j]!=Integer.MAX_VALUE)return arr[i][j];

            int d =  pathSum( m,n,i+1,j,arr,matrix);
            int leftDown =  pathSum( m,n,i+1,j-1,arr,matrix);
            int rightDown =  pathSum( m,n,i+1,j+1,arr,matrix);

            return arr[i][j] = matrix[i][j] + Math.min(d,Math.min(leftDown,rightDown));
        }



        public int minFallingPathSum(int[][] matrix) {
            int minSum=Integer.MAX_VALUE;
            int n=matrix.length;

            int [][]arr = new int[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(arr[i],Integer.MAX_VALUE);
            }
            for(int j=0;j<n;j++){
                int min = pathSum(n,n,0,j,arr,matrix);
                minSum=Math.min(minSum,min);
            }

            return minSum;
        }
    }

    //120. Triangle
    class Solution4 {
        private int pathSum(List<List<Integer>> triangle,int i,int j,int [][]arr){
            if(i==triangle.size()-1){
                return triangle.get(i).get(j);
            }

            if(arr[i][j]!=Integer.MAX_VALUE)return arr[i][j];

            int left = pathSum(triangle,i+1,j,arr);
            int right = pathSum(triangle,i+1,j+1,arr);

            return arr[i][j]=triangle.get(i).get(j) + Math.min(left,right);
        }
        public int minimumTotal(List<List<Integer>> triangle) {
            int n=triangle.size();
            int [][]arr = new int[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(arr[i],Integer.MAX_VALUE);
            }
            return pathSum(triangle,0,0,arr);
        }
    }

   ///2684. Maximum Number of Moves in a Grid
    class Solution4 {
        private int maxMove(int [][]grid,int row,int col,int m,int n,int [][]dp){
            if(row<0 || row>=m)return 0;
            if(col>=n-1)return 0;

            int du=0;
            int s=0;
            int dd=0;
            if(dp[row][col]!=-1)return dp[row][col];

            if(row>0 && grid[row-1][col+1]> grid[row][col]){
                du = 1+maxMove(grid,row-1,col+1,m,n,dp);
            }
            if(col<n && grid[row][col+1]> grid[row][col]){
                s = 1+maxMove(grid,row,col+1,m,n,dp);
            }
            if(row<m-1 && grid[row+1][col+1]> grid[row][col]){
                dd = 1+maxMove(grid,row+1,col+1,m,n,dp);
            }

            return dp[row][col]=Math.max(du,Math.max(s,dd));

        }
        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int max=0;
            int [][]dp=new int[m][n];

            for(int i=0;i<m;i++){
                Arrays.fill(dp[i],-1);
            }

            for(int i=0;i<m;i++){
                max = Math.max(max,maxMove(grid,i,0,m,n,dp));
            }

            return max;
        }
    }


}