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
}