class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[n * 2 - 1];
        fill(new HashSet<>() , n , res , 0);
        return res;
    }

    public boolean fill(HashSet<Integer> set , int n , int[] res , int i){
        if(set.size() == n) return true;
        if(i == res.length) return false;
        if(res[i] != 0){
            return fill(set , n , res , i + 1);
        }
        for(int  j = n ; j >= 1 ; j-- ){
            if(!set.contains(1) && j == 1){
                set.add(1);
                res[i] = 1;
                if (fill(set , n , res , i + 1)){
                    return true;
                }
                set.remove(1);
                res[i] = 0;
            }
            if(!set.contains(j) && res[i] == 0 && (i + j) <( n * 2 - 1) && res[i + j] == 0){
                set.add(j);
                res[i] = j;
                res[i + j] = j;
                if (fill(set , n , res , i + 1)){
                    return true;
                }
                set.remove(j);
                res[i] = 0;
                res[i + j] = 0;
            }
        }
        return false;
    }    
}
