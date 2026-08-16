class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // 1. Sort by ascending start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        
        // Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // 2. Iterate through remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextStart <= currentEnd) {
                // Overlap: extend the current interval's end if necessary
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: move to the next interval and add it to the list
                currentInterval = intervals[i];
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}