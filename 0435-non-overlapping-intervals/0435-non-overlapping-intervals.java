class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 1. Sort by end time in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        // 2. Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlap detected: greedily remove the current interval
                count++;
            } else {
                // No overlap: keep the interval and update end boundary
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}