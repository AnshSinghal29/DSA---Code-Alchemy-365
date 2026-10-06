/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            // Integer overflow se bachne ke liye standard mid formula
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // Agar mid bad hai, toh pehla bad version mid ya uske left mein hoga
                right = mid;
            } else {
                // Agar mid good hai, toh pehla bad version mid ke right mein hoga
                left = mid + 1;
            }
        }

        // Jab left == right ho jaye, loop break ho jata hai aur wahi first bad version hai
        return left;
    }
}