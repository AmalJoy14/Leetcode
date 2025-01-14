class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int n = A.length;
        int[] C = new int[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(set.contains(A[i])){
                count++;
            }
            else{
                set.add(A[i]);
            }

            if(set.contains(B[i])){
                count++;
            }
            else{
                set.add(B[i]);
            }
            C[i] = count;
        }
        return C;
    }
}
