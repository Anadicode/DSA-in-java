class Slide{
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
}