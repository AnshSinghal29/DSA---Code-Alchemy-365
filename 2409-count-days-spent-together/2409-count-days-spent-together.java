class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Convert all dates to day of the year (1 to 365)
        int aliceArrival = convertToDay(arriveAlice, daysInMonths);
        int aliceLeave = convertToDay(leaveAlice, daysInMonths);
        
        int bobArrival = convertToDay(arriveBob, daysInMonths);
        int bobLeave = convertToDay(leaveBob, daysInMonths);
        
        // Find the overlapping interval
        int overlapStart = Math.max(aliceArrival, bobArrival);
        int overlapEnd = Math.min(aliceLeave, bobLeave);
        
        // Calculate total overlapping days
        if (overlapStart <= overlapEnd) {
            return overlapEnd - overlapStart + 1;
        }
        
        return 0;
    }
    
    private int convertToDay(String date, int[] daysInMonths) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = day;
        for (int i = 1; i < month; i++) {
            totalDays += daysInMonths[i];
        }
        
        return totalDays;
    }
}