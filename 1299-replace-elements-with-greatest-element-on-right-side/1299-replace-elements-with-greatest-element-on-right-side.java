class Solution {
    public int[] replaceElements(int[] arr) {
        // The last element is always replaced with -1
        int maxSoFar = -1;
        
        // Loop backward from the end to the beginning
        for (int i = arr.length - 1; i >= 0; i--) {
            // 1. Save the current element before we overwrite it
            int currentElement = arr[i];
            
            // 2. Replace the current element with the largest seen so far
            arr[i] = maxSoFar;
            
            // 3. Update the largest seen so far for the next iteration
            maxSoFar = Math.max(maxSoFar, currentElement);
        }
        
        return arr;
    }
}