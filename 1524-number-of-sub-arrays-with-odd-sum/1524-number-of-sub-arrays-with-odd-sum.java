class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        long oddCount = 0, evenCount = 1; // prefix sum 0 is even
        long currentSum = 0;
        long totalSubarrays = 0;
        
        for (int num : arr) {
            currentSum += num;
            
            if (currentSum % 2 == 1) {
                // If current prefix sum is odd, it forms an odd subarray sum with previous even prefix sums
                totalSubarrays = (totalSubarrays + evenCount) % MOD;
                oddCount++;
            } else {
                // If current prefix sum is even, it forms an odd subarray sum with previous odd prefix sums
                totalSubarrays = (totalSubarrays + oddCount) % MOD;
                evenCount++;
            }
        }
        
        return (int) totalSubarrays;
    }
}