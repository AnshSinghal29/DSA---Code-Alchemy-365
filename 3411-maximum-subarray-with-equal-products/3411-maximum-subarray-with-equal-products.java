class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 1; // Single element subarray is always valid
        
        // Max possible LCM for elements 1..10 is 2520, max GCD is 10 -> limit = 25200
        long LIMIT = 25200L; 
        
        for (int i = 0; i < n; i++) {
            long prod = 1;
            long currentGcd = 0;
            long currentLcm = 1;
            
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                
                // Break early to avoid overflow if prod exceeds max possible (LCM * GCD)
                if (prod > LIMIT) {
                    break;
                }
                
                currentGcd = (j == i) ? nums[j] : gcd(currentGcd, nums[j]);
                currentLcm = (j == i) ? nums[j] : lcm(currentLcm, nums[j]);
                
                if (prod == currentLcm * currentGcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}