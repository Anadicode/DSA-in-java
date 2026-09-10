class DP{
  //  70. Climbing Stairs
    class Solution {
        private Map<Integer,Integer>mp = new HashMap<>();

        public int climbStairs(int n) {
            if(n==0||n==1)return 1;
            if(!mp.containsKey(n)){
                mp.put(n,climbStairs(n-1) + climbStairs(n-2));
            }
            return mp.get(n) ;
        }
    }
// 746 min cost to climb a stair
    class Solution {

        private int cost(int i, int []Cost,int []dp){
            if(i<0)return 0;
            if(i==0)return Cost[0];

            if(dp[i]!=-1) return dp[i];

            return dp[i] =Cost[i]+Math.min(cost(i-1,Cost,dp),cost(i-2,Cost,dp));

        }
        public int minCostClimbingStairs(int[] Cost) {
            int [] dp = new int[Cost.length];
            Arrays.fill(dp,-1);
            int i=Cost.length;
            return Math.min(cost(i-1,Cost,dp),cost(i-2,Cost,dp));
        }
    }
}