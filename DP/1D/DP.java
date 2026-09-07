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
}