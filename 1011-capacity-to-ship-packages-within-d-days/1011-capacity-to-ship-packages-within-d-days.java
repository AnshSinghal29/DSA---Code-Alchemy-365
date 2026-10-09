class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left  = 0;
        int right = 0;

        for(int w : weights){
            left = Math.max(left,w);
            right+=w;
        }
        int minCapacity = right;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(canShip(weights,days,mid)){
                minCapacity = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return minCapacity;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int currentDays = 1;
        int currentWeight = 0;

        for (int w : weights) {
            if (currentWeight + w > cap) {
                currentDays++;
                currentWeight = 0;
            }
            currentWeight += w;
        }

        return currentDays <= days;
    }
}