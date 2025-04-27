class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;
        ArrayList<int[]> list = new ArrayList<>();
        HashSet<Long> set = new HashSet<>();
        Arrays.sort(buildings , (a,b) -> {
            if(Integer.compare(a[0], b[0]) == 0){
                return Integer.compare(a[1], b[1]);
            }
            else{
                return Integer.compare(a[0], b[0]);
            }
            
            });
        for(int i = 1 ; i < m - 1 ; i++){
            if(buildings[i-1][0] == buildings[i][0] && buildings[i+1][0] == buildings[i][0]){
                long val = (long)buildings[i][0] * 100000 + buildings[i][1];
                set.add(val);
            }
        }
        //System.out.println(set);
         HashSet<Long> set2 = new HashSet<>();
        Arrays.sort(buildings , (a,b) -> {
            if(Integer.compare(a[1], b[1]) == 0){
                return Integer.compare(a[0], b[0]);
            }
            else{
                return Integer.compare(a[1], b[1]);
            }
            
            });
        for(int i = 1 ; i < m - 1 ; i++){
            if(buildings[i-1][1] == buildings[i][1] && buildings[i+1][1] == buildings[i][1]){
                long val = (long)buildings[i][0] * 100000 + buildings[i][1];
                set2.add(val);
            }
        }
        //System.out.println(set2);
        int count = 0;
        for(long num : set){
            if(set2.contains(num)) count++;
        }
        return count;
    }
}
