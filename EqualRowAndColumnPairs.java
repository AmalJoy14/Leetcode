class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> rowMap = new HashMap<>();
        int count = 0;
        
        // Add rows to the hashmap.
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[i][j]).append(",");
            }
            String rowString = sb.toString();
            rowMap.put(rowString, rowMap.getOrDefault(rowString, 0) + 1);
        }
        
        // Compare columns with rows.
        for (int j = 0; j < grid.length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid.length; i++) {
                sb.append(grid[i][j]).append(",");
            }
            String colString = sb.toString();
            if (rowMap.containsKey(colString)) {
                count += rowMap.get(colString);
            }
        }
        return count;
    }
}
