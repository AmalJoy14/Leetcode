class Solution {
    public int maxPossibleScore(int[] start, int d) {
        int left = 0 , right = 2_000_000_000 , res = -1;
        Arrays.sort(start);
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(mid , start ,d)){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
    public boolean isPossible(int mid , int[] start , int d){
        int[] arr = start.clone();
        for(int i = 1 ; i < start.length ; i++){
            int diff = arr[i] - (arr[i - 1]);
            int add = mid - diff;
            if(add > d){
                return false;
            }
            if(diff < mid)
                arr[i] += add;
        }
        return true;
    }
}
