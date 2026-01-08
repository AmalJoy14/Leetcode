class Solution {
    int m , n , res = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        n = students[0].length;
        int[] taken = new int[m];
        findMax(students , mentors , 0 , taken, 0);
        return res;
    }
    public void findMax(int[][] students , int[][] mentors , int i , int[] taken , int result){
        if(i == m){
            res = Math.max(res , result);
            return;
        }
        for(int j = 0 ; j < m ; j++){
            if(taken[j] == 0){
                int count = 0;
                for(int k = 0 ; k < n ; k++){
                    if(students[i][k] == mentors[j][k]) count++;
                }
                taken[j] = 1;
                findMax(students , mentors , i + 1 , taken, result + count);
                taken[j] = 0;
            }
        }
    }
}
