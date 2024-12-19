class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        for (int i = 0 ; i < arr.length ; i++){
            int start = i,end = arr[i];
            for(int j = start ; j <= end ; j++){
                if(arr[j] > end){
                    end = arr[j];
                }
            }
            i = end;
            count++;
        }
        return count;
    }
}
