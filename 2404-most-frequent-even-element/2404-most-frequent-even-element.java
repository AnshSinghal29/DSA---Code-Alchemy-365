
import java.io.*;
import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = -1;
        int maxFreq = 0;

        for (int num : nums) {

            if (num % 2 == 0) {

                map.put(num, map.getOrDefault(num, 0) + 1);

                int freq = map.get(num);

                if (freq > maxFreq || 
                   (freq == maxFreq && (ans == -1 || num < ans))) {

                    maxFreq = freq;
                    ans = num;
                }
            }
        }

        return ans;
    }
}
