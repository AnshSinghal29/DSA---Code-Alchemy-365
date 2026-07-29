class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the ends of the valid elements
        int p1 = m - 1;
        int p2 = n - 1;
        
        // Pointer for the very end of nums1 (the empty space)
        int p = m + n - 1;
        
        // While there are still elements to merge from nums2
        while (p2 >= 0) {
            // If p1 is still valid and has a larger number, place it at the end
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } 
            // Otherwise, the number from nums2 is larger (or equal), place it at the end
            else {
                nums1[p] = nums2[p2];
                p2--;
            }
            // Move the placement pointer backwards
            p--;
        }
    }
}