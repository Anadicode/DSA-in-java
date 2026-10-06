package SlidingWindow;

class Pattern2{
    class Solution {

        //1423. Maximum Points You Can Obtain from Cards
        public int maxScore(int[] cardPoints, int k) {
            int rightCount=0;
            int l=k-1,r=cardPoints.length-1;
            int maxSum=0;
            for(int i=0;i<k;i++){
                maxSum+=cardPoints[i];
            }

            int lSum=maxSum;
            int rSum=0;
            while(rightCount<k){
                lSum-=cardPoints[l];
                l--;
                rSum+=cardPoints[r];
                r--;
                rightCount++;
                if(lSum+rSum>maxSum)maxSum=lSum+rSum;
            }

            return maxSum;
        }
    }

    //1004. Max Consecutive Ones III
    class Solution1 {
        public int longestOnes(int[] arr, int k) {

            if(arr.length==k)return k;

            int max = 0;
            int countZeros = 0;

            int l=0,r=0;
            while(r<arr.length){

                if(arr[r]==0 )countZeros++;
                if(countZeros>k){
                    if(arr[l]==0 ){
                        countZeros--;
                    }
                    l++;
                }

                if((r-l+1)>max )max=(r-l+1);


                r++;
            }

            return max;

        }
    }

    //904. Fruit Into Baskets
    class Solution2 {
        public int totalFruit(int[] fruits) {
            Map<Integer,Integer> mp = new HashMap<>();
            int l=0,r=0;
            int max=0;

            while(r<fruits.length){


                if(mp.containsKey(fruits[r])){
                    mp.put(fruits[r],mp.getOrDefault(fruits[r], 0) + 1);
                }
                else if(!mp.containsKey(fruits[r])){
                    mp.put(fruits[r],1);
                }


                if(mp.size()>2){
                    mp.put(fruits[l],mp.getOrDefault(fruits[l], 0) - 1);
                    if(mp.get(fruits[l])<=0)mp.remove(fruits[l]);
                    l++;
                }

                max=Math.max(max,r-l+1);
                r++;


            }
            return max;
        }
    }

    //2401. Longest Nice Subarray
    class Solution3 {
        public int longestNiceSubarray(int[] nums) {
            int max = 1;
            int used=0;
            int l=0,r=0;

            while(r<nums.length){

                if((used & nums[r]) != 0){
                    used^=nums[l];
                    l++;
                    continue;
                }

                used|=nums[r];
                max=Math.max(max,r-l+1);
                r++;

            }

            return max;
        }
    }

}