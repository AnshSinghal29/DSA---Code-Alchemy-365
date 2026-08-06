class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
    
        if (numRows == 0) {
            return result;
        }
    
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1); 
            List<Integer> newRow = new ArrayList<>();
            
            
            newRow.add(1);
            
            for (int j = 1; j < i; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
  
            newRow.add(1);

            result.add(newRow);
        }
        
        return result;
    }
}