public class Array {

    //Kedans Algo
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }

        return max;
    }

    //Sort arrays 0's 1's and 2's using Dutch flag algo
    private void swap(int[]nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    public void sortColors(int[] nums) {
        int mid =0,low=0, high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums, mid, low);
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }

        }
    }

    public static void main(String[] args) {

    }
}