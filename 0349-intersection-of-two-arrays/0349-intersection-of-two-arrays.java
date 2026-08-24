class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer> set = new HashSet<>();
       Set<Integer> intersection = new HashSet<>();

       for(int num : nums1){
        set.add(num);
       } 

       for(int num : nums2){
        if(set.contains(num)){
            intersection.add(num);
        }
       }

       int[] result = new int[intersection.size()];
       int idx = 0;
       for(int num : intersection){
        result[idx++] = num;
       } 
       return result;
    }
}