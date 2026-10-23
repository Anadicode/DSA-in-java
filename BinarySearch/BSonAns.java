package BinarySearch;

public class BSonAns {

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
}
