class Solution {
    public String largestNumber(int[] nums) {
        // 1. Convert integers to Strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // 2. Sort using the custom concatenation comparator (descending order)
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // 3. Edge Case: If the largest number is "0", the entire result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 4. Combine into final string
        StringBuilder result = new StringBuilder();
        for (String s : strNums) {
            result.append(s);
        }

        return result.toString();
    }
}