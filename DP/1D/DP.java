class DP{


  //  70. Climbing Stairs
    class Solution1 {
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
    class Solution2 {

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

    //213. House Robber II
    class Solution3 {
        public long solve(List<Integer> arr) {
            int n = arr.size();

            // If there's only one house, return its value
            if (n == 1) return arr.get(0);

            // prev stores the maximum sum till the previous index
            long prev = arr.get(0);

            // prev2 stores the maximum sum till index before previous
            long prev2 = 0;

            // Iterate from the second house
            for (int i = 1; i < n; i++) {
                // Pick the current house and add value from prev2
                long pick = arr.get(i);
                if (i > 1) pick += prev2;

                // Skip the current house
                long nonPick = prev;

                // Choose maximum
                long cur_i = Math.max(pick, nonPick);

                // Update prev2 and prev
                prev2 = prev;
                prev = cur_i;
            }
            return prev;
        }
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            List<Integer>l1=new ArrayList<>();
            List<Integer>l2=new ArrayList<>();

            for(int i=0;i<nums.length;i++){
                if(i!=0) l1.add(nums[i]);
                if(i!=nums.length-1) l2.add(nums[i]);
            }
            return (int)Math.max(solve(l1),solve(l2));
        }
    }



}