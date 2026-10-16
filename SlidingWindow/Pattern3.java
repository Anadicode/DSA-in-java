package SlidingWindow;

//count no of subarrays
public class Pattern3 {


    //930. Binary Subarrays With Sum
    class Solution2 {
        private int numSubarraysWithLessSum(int[] nums, int goal){
            if(goal<0)return 0;
            int count=0,sum=0,l=0,r=0;

            while(r<nums.length){
                sum+=nums[r];

                while(sum>goal ){
                    sum-=nums[l];
                    l++;
                }

                count+=(r-l+1);
                r++;
            }

            return count;
        }
        public int numSubarraysWithSum(int[] nums, int goal) {
            return numSubarraysWithLessSum( nums, goal) - numSubarraysWithLessSum( nums, goal-1);
        }
    }



   //1248. Count Number of Nice Subarrays
    class Solution1 {
        private int noOfSubArrayLessSum(int []nums,int k){
            if(k<0)return 0;

            int sum=0,count=0,l=0,r=0;

            while(r<nums.length){
                sum+=nums[r];

                while(sum>k){
                    sum-=nums[l];
                    l++;
                }

                count+=r-l+1;
                r++;
            }

            return count;
        }
        public int numberOfSubarrays(int[] nums, int k) {
            for(int i=0;i<nums.length;i++){
                nums[i]=nums[i]%2;
            }

            // finding no of sub arrays <k    -  finding no of sub arrays <k
            return noOfSubArrayLessSum(nums,k) - noOfSubArrayLessSum(nums,k-1) ;
        }
    }

    //992. Subarrays with K Different Integers
    class Solution3 {

        // return the No. of sub Arrays <= k size
        private int noOfSubArraysLessEqual(int [] nums, int k){
            Map<Integer,Integer> mp = new HashMap<>();
            int l=0,r=0,count=0;

            while(r<nums.length){

                mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);

                // if the map size > k we shrink it down from the left
                while(mp.size()>k){

                    mp.put(nums[l],mp.getOrDefault(nums[l],0)-1);

                    if(mp.getOrDefault(nums[l],0)==0){
                        mp.remove(nums[l]);
                    }
                    l++;
                }
                // counting every possible no of sub arrays
                count+=r-l+1;
                r++;
            }

            return count;
        }

        public int subarraysWithKDistinct(int[] nums, int k) {

           // return the No. of sub Arrays <= k size - return the No. of sub Arrays <= k-1 size
            return noOfSubArraysLessEqual(nums, k) - noOfSubArraysLessEqual(nums, k-1);
        }
    }

}
