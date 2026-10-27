package BinarySearch;

public class BSonAns {


    class Solution0 {

        // finding the ceil value sum
        private long ceilValueSum(int []nums , int divisor){
            long sum = 0;

            for(var e:nums){
                // calculaating  the ceil value
                sum+= (e+divisor - 1L)/divisor;
            }

            return sum;
        }


        public int smallestDivisor(int[] nums, int threshold) {

            int min = 1;
            int max = nums[0];

            // finding max range
            for(var e:nums){
                max = Math.max(max,e);
            }


            while(min<=max){
                int mid = min + (max-min)/2;

                if(ceilValueSum(nums ,mid)>threshold) min = mid+1;
                else
                    max = mid-1;

            }

            return min;
        }
    }


    //1011. Capacity To Ship Packages Within D Days
    class Solution1 {
        public int shipWithinDays(int[] weights, int days) {

            int low = 0;
            int high = 0;

            // Find the minimum and maximum possible capacities
            for (int w : weights) {
                low = Math.max(low, w);
                high += w;
            }

            // Binary search on the answer
            while (low <= high) {

                int mid = low + (high - low) / 2;

                int daysNeeded = 1;
                int currentWeight = 0;

                // Check how many days capacity mid requires
                for (int w : weights) {
                    if (currentWeight + w > mid) {
                        daysNeeded++;
                        currentWeight = 0;
                    }

                    currentWeight += w;
                }

                if (daysNeeded <= days) {
                    high = mid - 1; // Try a smaller capacity
                } else {
                    low = mid + 1;  // Need a larger capacity
                }
            }

            return low;
        }
    }

   //875. Koko Eating Bananas
    class Solution2 {
        public int minEatingSpeed(int[] piles, int h) {

            int low=1,high=1;

            // finding the max range
            for(int e:piles){
                high=Math.max(high,e);
            }

            int ans=0;
            while(low<=high){
                int mid = low+(high-low)/2;

                // calculating total hours if koko eats 'mid no. of bananas'/hour
                long totalSum=0;
                for(int e:piles){
                    // (e+mid-1)/mid;  calculating ceil value
                    totalSum+=(e+mid-1L)/mid;
                }

                if(totalSum<=h){
                    high=mid-1;
                }
                else
                    low=mid+1;
            }

            return low;
        }
    }
    //1482. Minimum Number of Days to Make m Bouquets
    class Solution3 {
        private boolean possible(int [] arr, int day, int m, int k){

            int count=0, noOfB=0;

            for(int i=0;i<arr.length;i++){
                if(arr[i]<=day){
                    count++;
                }else{
                    noOfB+=(count/k);
                    count=0;
                }
            }
            noOfB+=(count/k);

            return  noOfB>=m;
        }


        public int minDays(int[] bloomDay, int m, int k) {
            if((long)m*k>bloomDay.length)return -1;

            // finding range
            int min = bloomDay[0],max = bloomDay[0];

            for(var e: bloomDay){
                min = Math.min(e,min);
                max = Math.max(e,max);
            }

            // fining the minimum day

            int minDay = max;

            while(min<=max){
                int mid = min+(max-min)/2;

                if(!possible(bloomDay,mid,m,k)){
                    min=mid+1;
                }
                else{
                    max=mid-1;
                    minDay=mid;
                }

            }

            return minDay;
        }
    }

    //1539. Kth Missing Positive Number
    class Solution4 {
        public int findKthPositive(int[] arr, int k) {

            int l=0,h=arr.length-1;

            while(l<=h){
                int mid = l+(h-l)/2;
                int missing=arr[mid] - (mid+1);

                if(missing<k)l=mid+1;
                else
                    h=mid-1;
            }

            return l+k;
        }
    }

}
