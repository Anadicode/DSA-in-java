package BinarySearch;

public class BS {

    //162. Find Peak Element
    class Solution1 {
        public int findPeakElement(int[] nums) {

            int left = 0, right = nums.length-1;

            while(left<right){
                int mid = left+(right-left)/2;

                if(nums[mid]>nums[mid+1]){
                    right=mid;
                }
                else if(nums[mid]<nums[mid+1]){
                    left=mid+1;
                }

                if(left==right) break;
            }

            return left;

        }
    }



}
